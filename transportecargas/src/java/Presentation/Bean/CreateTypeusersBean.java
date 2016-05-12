package Presentation.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;
import BusinessLogic.Controller.HandleTypeusers;
import DataAccess.Entity.Typeusers;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author Grupo 6 - Transportes de Carga
 */

@ManagedBean
@ViewScoped
@SessionScoped
public class CreateTypeusersBean {

    private Integer idTypeuser;
    private String nameTypeuser;
    private String descriptionTypeuser;
    private String response;
    private List listHandleTypeusers;
    private List searchListHandleTypeusers = null;
    private Typeusers typeuser = null;
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
    
    public List getSearchListHandleTypeusers(){
        if (searchListHandleTypeusers == null){
            FacesContext context = FacesContext.getCurrentInstance();
            HandleTypeusers searchTypeusers = new HandleTypeusers();
            Integer typesearch = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("tsearch"));
            String search = context.getExternalContext().getRequestParameterMap().get("dsearch");
            searchListHandleTypeusers = searchTypeusers.listManyTypeusers(typesearch, search);
        }
        return searchListHandleTypeusers;
    }
    
    public Typeusers getTypeuser(){
        if (typeuser == null){
            FacesContext context = FacesContext.getCurrentInstance();
            HandleTypeusers updateTypeusers = new HandleTypeusers();
            Integer idtypeuser = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idtypeuser"));
            typeuser = updateTypeusers.updateTypeusers(idtypeuser);
        }
        return typeuser;
    }
    
    public List getListHandleTypeusers() {
        HandleTypeusers listtypeusers = new HandleTypeusers();
        listHandleTypeusers = listtypeusers.listAllTypeusers();
        return listHandleTypeusers;
    }

    public void setListHandleTypeusers(List listHandleTypeusers) {
        this.listHandleTypeusers = listHandleTypeusers;
    }

    public Integer getIdTypeuser() {
        return idTypeuser;
    }

    public void setIdTypeuser(Integer idTypeuser) {
        this.idTypeuser = idTypeuser;
    }

    public String getNameTypeuser() {
        return nameTypeuser;
    }

    public void setNameTypeuser(String nameTypeuser) {
        this.nameTypeuser = nameTypeuser;
    }

    public String getDescriptionTypeuser() {
        return descriptionTypeuser;
    }

    public void setDescriptionTypeuser(String descriptionTypeuser) {
        this.descriptionTypeuser = descriptionTypeuser;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void createTypeusers(){
        HandleTypeusers createtypeusers = new HandleTypeusers();
        response = createtypeusers.createTypeUser(nameTypeuser, descriptionTypeuser);
    }

    public String deleteTypeusers(){
        FacesContext context = FacesContext.getCurrentInstance();
        HandleTypeusers deleteTypeusers = new HandleTypeusers();
        Integer pruebanumero = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idtypeuser"));
        response = deleteTypeusers.deleteTypeusers(pruebanumero);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El tipo de usuario no existe.");
            context.addMessage(null, message);
            return null;
        } else if (response.equals("err2")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El tipo de usuario esta relacionado con usuarios.");
            context.addMessage(null, message);
            return null;
        } else {
            return "listTypeusers";
        }
    }

    public String updateTypeusers(){
        FacesContext context = FacesContext.getCurrentInstance();
        HandleTypeusers updateTypeusers = new HandleTypeusers();
        Integer idtypeuser = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idtypeuser"));
        typeuser = updateTypeusers.updateTypeusers(idtypeuser);
        if (typeuser == null){
            return "No se encontro el tipo de usuario.";
        } else {
            return "editSingleTypeusers";
        }
    }

    public String editTypeusers() {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleTypeusers edittypeusers = new HandleTypeusers();
        Integer idtype = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idtype"));
        String nametype = context.getExternalContext().getRequestParameterMap().get("nametype");
        String descriptiontype = context.getExternalContext().getRequestParameterMap().get("descriptiontype");
        response = edittypeusers.editTypeusers(idtype, nametype, descriptiontype);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló la edición!",
                    "No se pudo guardar la información.");
            context.addMessage(null, message);
            return null;
        } else {
            return "listTypeusers";
        }
    }
    
    public String searchTypeusers(){
        return "resultTypeusers";
    }
}
