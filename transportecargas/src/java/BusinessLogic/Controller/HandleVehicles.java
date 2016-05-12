package BusinessLogic.Controller;

import DataAccess.DAO.VehiclesDAO;
import DataAccess.Entity.Vehicles;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class HandleVehicles {

    public String createVehicle(String idVehicle, String colorVehicle, int modelyearVehicle, String typeVehicle, String brandVehicle){
        Vehicles vehicles = new Vehicles();
        vehicles.setIdVehicle(idVehicle);
        vehicles.setColorVehicle(colorVehicle);
        vehicles.setModelyearVehicle(modelyearVehicle);
        vehicles.setTypeVehicle(typeVehicle);
        vehicles.setBrandVehicle(brandVehicle);
        vehicles.setActiveVehicle(true);
        vehicles.setDatecreatedVehicle(new Date());
        VehiclesDAO vehiclesDAO = new VehiclesDAO();
        Vehicles vehiclesE = vehiclesDAO.persist(vehicles);
        if (vehiclesE != null) {
            return "El vehículo con placa " + vehicles.getIdVehicle() + " ha sido creado.";
        } else {
            return "El vehículo no pudo ser creado.";
        }        
    }

    public List listAllVehicles(){
        VehiclesDAO vehiclesDAO = new VehiclesDAO();
        List listTypeusers = null;
        listTypeusers = vehiclesDAO.findVehiclesEntities();
        return listTypeusers;
    }

    public String deleteVehicles(String idVehicle){
        String response;
        VehiclesDAO vehicleDAO = new VehiclesDAO();
        response = vehicleDAO.deleteByIdVehicle(idVehicle);
        return response;
    }

    public String editVehicles(String idVehicle, String colorVehicle, int modelyearVehicle, String typeVehicle, String brandVehicle){
        String response;
        VehiclesDAO vehicleDAO = new VehiclesDAO();
        response = vehicleDAO.editVehicle(idVehicle, colorVehicle, modelyearVehicle, typeVehicle, brandVehicle);
        return response;
    }

    public List listManyVehicles(Integer typesearch, String search){
        VehiclesDAO vehiclesDAO = new VehiclesDAO();
        List listVehicles = null;
        listVehicles = vehiclesDAO.searchVehicle(typesearch, search);
        return listVehicles;
    }
    
    public Vehicles updateVehicles (String idVehicle){
        VehiclesDAO vehiclesDAO = new VehiclesDAO();
        Vehicles obvehicles = null;
        obvehicles = vehiclesDAO.searchByIdVehicle(idVehicle);
        return obvehicles;
    }

}
