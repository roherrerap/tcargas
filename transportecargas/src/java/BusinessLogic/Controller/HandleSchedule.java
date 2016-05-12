/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.UsersDAO;
import DataAccess.DAO.VehiclesDAO;
import DataAccess.DAO.VehicleschedulesDAO;
import DataAccess.Entity.Users;
import DataAccess.Entity.Vehicles;
import DataAccess.Entity.Vehicleschedules;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class HandleSchedule {

    public String createSchedule(String vehicleID, String timeAssigned, String timefinalAssigned, String travel, Long idUser) throws ParseException{
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateassigned = dateformat.parse(timeAssigned);
        Date datefinalassigned = dateformat.parse(timefinalAssigned);
        Vehicleschedules vehicleschedules = new Vehicleschedules();
        UsersDAO usersDAO = new UsersDAO();
        Users users = usersDAO.searchByIdUser(idUser);
        VehiclesDAO vehiclesDAO = new VehiclesDAO();
        Vehicles vehicles = vehiclesDAO.searchByIdVehicle(vehicleID);

        vehicleschedules.setVehiclesIdVehicle(vehicles);
        vehicleschedules.setUsersIdUser(users);
        vehicleschedules.setTravelassignedVschedule(travel);
        vehicleschedules.setTimeassignedVschedule(dateassigned);
        vehicleschedules.setTimefinalassignedVschedule(datefinalassigned);
        vehicleschedules.setDatecreatedVschedule(new Date());
        vehicleschedules.setActiveVschedule(true);

        VehicleschedulesDAO vehicleshedulesDAO = new VehicleschedulesDAO();
        Vehicleschedules vehiclesheduleNew = vehicleshedulesDAO.persist(vehicleschedules);
        
        if (vehiclesheduleNew != null) {
            return "El horario ha sido guardado.";
        } else {
            return "El horario no ha sido almacenado.";
        }        
        
    }


    
    public List listAllSchedules(){
        VehicleschedulesDAO vScheduleDAO = new VehicleschedulesDAO();
        List listSchedulesVehicles = null;
        listSchedulesVehicles = vScheduleDAO.findVehicleshedulesEntities();
        return listSchedulesVehicles;
    }
    
    public String editSchedules(Integer idschedule, String idvehicle, String travel, String timeassigned, String timefinalassigned) throws ParseException{
        String response;
        VehicleschedulesDAO vScheduleDAO = new VehicleschedulesDAO();
        response = vScheduleDAO.editSchedule(idschedule, idvehicle, travel, timeassigned, timefinalassigned);
        return response;
    }
    
    public String deleteSchedules(Integer idVschedule){
        String response;
        VehicleschedulesDAO vshedulesDAO = new VehicleschedulesDAO();
        response = vshedulesDAO.deleteSchedule(idVschedule);
        return response;
    }

    public List listManySchedules(Integer typesearch, String search){
        VehicleschedulesDAO vehicleschedulesDAO = new VehicleschedulesDAO();
        List listSchedules = null;
        listSchedules = vehicleschedulesDAO.searchSchedule(typesearch, search);
        return listSchedules;
    }
    
    public Vehicleschedules updateSchedules (String idSchedule){
        VehicleschedulesDAO vehicleschedulesDAO = new VehicleschedulesDAO();
        Vehicleschedules obschedules = null;
        obschedules = vehicleschedulesDAO.searchByIdSchedule(idSchedule);
        return obschedules;
    }
    
}
