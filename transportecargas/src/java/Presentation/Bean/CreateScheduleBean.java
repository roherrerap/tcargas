package Presentation.Bean;

import BusinessLogic.Controller.HandleSchedule;
import java.text.ParseException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */

@SessionScoped
@ManagedBean
@ViewScoped
public class CreateScheduleBean {

    private int idSchedule;
    private boolean activeSchedule;
    private String dateCreate;
    private String timeAssigned;
    private String timefinalAssigned;
    private String travel;
    private long userId;
    private String vehicleID;
    
    private String message;
    private List listHandleSchedule;
    private String response;

    public List getListHandleSchedule() {
        HandleSchedule listSchedule = new HandleSchedule();
        listHandleSchedule = listSchedule.listAllSchedules();
        return listHandleSchedule;
    }

    public void setListHandleSchedule(List listHandleSchedule) {
        this.listHandleSchedule = listHandleSchedule;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public boolean isActiveSchedule() {
        return activeSchedule;
    }

    public void setActiveSchedule(boolean activeSchedule) {
        this.activeSchedule = activeSchedule;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getTimeAssigned() {
        return timeAssigned;
    }

    public void setTimeAssigned(String timeAssigned) {
        this.timeAssigned = timeAssigned;
    }

    public String getTimefinalAssigned() {
        return timefinalAssigned;
    }

    public void setTimefinalAssigned(String timefinalAssigned) {
        this.timefinalAssigned = timefinalAssigned;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void createSchedule() throws ParseException{
        FacesContext context = FacesContext.getCurrentInstance();
        HandleSchedule createSchedule = new HandleSchedule();
        Long iduser = Long.parseLong(context.getExternalContext().getRequestParameterMap().get("iduser"));
        message = createSchedule.createSchedule(vehicleID, timeAssigned, timefinalAssigned, travel, iduser);
    }
    
    public String editSchedules() throws ParseException {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleSchedule editSchedule = new HandleSchedule();
        Integer idschedule = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idschedule"));
        String vehicleid = context.getExternalContext().getRequestParameterMap().get("vehicleid");
        String travel = context.getExternalContext().getRequestParameterMap().get("travel");
        String timeassigned = context.getExternalContext().getRequestParameterMap().get("timeassigned");
        String timefinalassigned = context.getExternalContext().getRequestParameterMap().get("timefinalassigned");
        response = editSchedule.editSchedules(idschedule, vehicleid, travel, timeassigned, timefinalassigned);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló la edición!",
                    "No se pudo guardar la información.");
            context.addMessage(null, message);
            return null;
        } else {
            return "editSchedule";
        }
    }
 
    public String deleteSchedule() {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleSchedule deleteSchedule = new HandleSchedule();
        Integer idSchedule = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("idschedule"));
        response = deleteSchedule.deleteSchedules(idSchedule);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El horario asignado no existe.");
            context.addMessage(null, message);
            return null;
        } else if (response.equals("err2")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El tipo de usuario esta relacionado con usuarios.");
            context.addMessage(null, message);
            return null;
        } else {
            return "deleteSchedule";
        }
    }
    
}