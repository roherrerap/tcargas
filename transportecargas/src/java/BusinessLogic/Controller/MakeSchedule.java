/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.UsersDAO;
import DataAccess.DAO.VehicleschedulesDAO;
import DataAccess.Entity.Users;
import DataAccess.Entity.Vehicleschedules;
import DataAccess.DAO.VehiclesDAO;
import DataAccess.Entity.Vehicles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class MakeSchedule {

    public ROB make(String username, String password, String datefinal, String description) throws ParseException{        
        UsersDAO usersDAO = new UsersDAO();
        Users usernameUSR = usersDAO.searchByUsername(username);
        ROB rob = new ROB();
        if (usernameUSR != null){
            if (usernameUSR.getPasswordUser().equals(password)){
                VehiclesDAO vehiclesDAO = new VehiclesDAO();
                Vehicles vehicles = vehiclesDAO.searchByIdVehicle("AAA-000");
                if (vehicles != null){
                    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
                    Date final_date = dateformat.parse(datefinal);
                    Vehicleschedules vehicleschedules = new Vehicleschedules();

                    vehicleschedules.setTravelassignedVschedule(description);
                    vehicleschedules.setTimeassignedVschedule(new Date());
                    vehicleschedules.setTimefinalassignedVschedule(final_date);
                    vehicleschedules.setUsersIdUser(usernameUSR);
                    vehicleschedules.setVehiclesIdVehicle(vehicles);
                    vehicleschedules.setDatecreatedVschedule(new Date());
                    vehicleschedules.setActiveVschedule(true);

                    VehicleschedulesDAO vehicleschedulesDAO = new VehicleschedulesDAO();
                    Vehicleschedules newTransaction = vehicleschedulesDAO.persist(vehicleschedules);

                    rob.setSuccess(true);
                    rob.setErr_message("Transacción Satisfactoria");
                    rob.setData(newTransaction.getIdVschedule().longValue());
                    return rob;
                } else {
                    rob.setSuccess(false);
                    rob.setErr_message("Vehículo Inexistente");
                    return rob;      
                }
            } else {
                rob.setSuccess(false);
                rob.setErr_message("Contraseña Incorrecta");
                return rob;      
            }
        } else {
            rob.setSuccess(false);
            rob.setErr_message("Usuario Inexistente");
            return rob;      
        }
    }
    
    public ROB check(String username, String password, String description){
        UsersDAO usersDAO = new UsersDAO();
        Users usernameUSR = usersDAO.searchByUsername(username);
        ROB rob = new ROB();
        if (usernameUSR != null){
            if (usernameUSR.getPasswordUser().equals(password)){
                VehicleschedulesDAO vehicleschedulesDAO = new VehicleschedulesDAO();
                Vehicleschedules vehicleschedules = vehicleschedulesDAO.searchByTravel(description);
                if (vehicleschedules != null){
                    List listSchedules = null;
                    listSchedules = vehicleschedulesDAO.searchTravel(description);
                    rob.setSuccess(true);
                    rob.setErr_message("Transacción Satisfactoria");
                    rob.setInformation(listSchedules);
                    return rob;
                } else {
                    rob.setSuccess(false);
                    rob.setErr_message("Identificador no existente");
                    return rob;      
                }
            } else {
                rob.setSuccess(false);
                rob.setErr_message("Contraseña Incorrecta");
                return rob;      
            }
        } else {
            rob.setSuccess(false);
            rob.setErr_message("Usuario Inexistente");
            return rob;      
        }
    }
}
