package Presentation.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import BusinessLogic.Controller.HandleVehicles;
import DataAccess.Entity.Vehicles;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */

@ManagedBean
@ViewScoped
public class CreateVehiclesBean {
    
    private String idVehicle;
    private String colorVehicle;
    private int modelyearVehicle;
    private String typeVehicle;
    private String brandVehicle;
    private String response;
    private List listHandleVehicles;
    private List searchListHandleVehicles = null;
    private Vehicles vehicle = null;
    private String search;
    private Integer typeSearch;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getTypeSearch() {
        return typeSearch;
    }

    public void setTypeSearch(Integer typeSearch) {
        this.typeSearch = typeSearch;
    }

    public List getSearchListHandleVehicles(){
        if (searchListHandleVehicles == null){
            FacesContext context = FacesContext.getCurrentInstance();
            HandleVehicles searchVehicles = new HandleVehicles();
            Integer typesearch = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("tsearch"));
            String search = context.getExternalContext().getRequestParameterMap().get("dsearch");
            searchListHandleVehicles = searchVehicles.listManyVehicles(typesearch, search);
        }
        return searchListHandleVehicles;
    }
    
    public Vehicles getVehicle(){
        if (vehicle == null){
            FacesContext context = FacesContext.getCurrentInstance();
            HandleVehicles updateVehicles = new HandleVehicles();
            String idvehicle = context.getExternalContext().getRequestParameterMap().get("idvehicles");
            vehicle = updateVehicles.updateVehicles(idvehicle);
        }
        return vehicle;
    }
    
    public List getListHandleVehicles() {
        HandleVehicles listvehicles = new HandleVehicles();
        listHandleVehicles = listvehicles.listAllVehicles();
        return listHandleVehicles;
    }

    public void setListHandleVehicles(List listHandleVehicles) {
        this.listHandleVehicles = listHandleVehicles;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getColorVehicle() {
        return colorVehicle;
    }

    public void setColorVehicle(String colorVehicle) {
        this.colorVehicle = colorVehicle;
    }

    public int getModelyearVehicle() {
        return modelyearVehicle;
    }

    public void setModelyearVehicle(int modelyearVehicle) {
        this.modelyearVehicle = modelyearVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getBrandVehicle() {
        return brandVehicle;
    }

    public void setBrandVehicle(String brandVehicle) {
        this.brandVehicle = brandVehicle;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    public void createVehicles(){   
        HandleVehicles createVehicles = new HandleVehicles();
        response = createVehicles.createVehicle(idVehicle, colorVehicle, modelyearVehicle, typeVehicle, brandVehicle);
    }

    public String deleteVehicles() {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleVehicles deleteVehicles = new HandleVehicles();
        String pruebanumero = context.getExternalContext().getRequestParameterMap().get("idvehicles");
        response = deleteVehicles.deleteVehicles(pruebanumero);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El vehículo no existe.");
            context.addMessage(null, message);
            return null;
        } else if (response.equals("err2")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El vehículo esta relacionado con registros de vehículos.");
            context.addMessage(null, message);
            return null;
        } else {
            return "listVehicles";
        }
    }

    public String editVehicles() {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleVehicles editvehicles = new HandleVehicles();
        String idvehicle = context.getExternalContext().getRequestParameterMap().get("idvehicle");
        String colorvehicle = context.getExternalContext().getRequestParameterMap().get("colorvehicle");
        int modelvehicle = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("modelvehicle"));
        String typevehicle = context.getExternalContext().getRequestParameterMap().get("typevehicle");
        String brandvehicle = context.getExternalContext().getRequestParameterMap().get("brandvehicle");
        response = editvehicles.editVehicles(idvehicle, colorvehicle, modelvehicle, typevehicle, brandvehicle);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló la edición!",
                    "No se pudo guardar la información.");
            context.addMessage(null, message);
            return null;
        } else {
            return "listVehicles";
        }
    }

    public String updateVehicles(){
        FacesContext context = FacesContext.getCurrentInstance();
        HandleVehicles updateVehicles = new HandleVehicles();
        String idvehicle = context.getExternalContext().getRequestParameterMap().get("idvehicles");
        vehicle = updateVehicles.updateVehicles(idvehicle);
        if (vehicle == null){
            return "No se encontro el vehículo.";
        } else {
            return "editSingleVehicles";
        }
    }

    public String searchVehicles(){
        return "resultVehicles";
    }
    
    public String enableVehicles(){
        return "listVehicles";
    }
    
}
