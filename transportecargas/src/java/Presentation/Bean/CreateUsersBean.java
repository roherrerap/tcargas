package Presentation.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import BusinessLogic.Controller.HandleUsers;
import DataAccess.Entity.Users;
import java.text.ParseException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author Grupo 6 - Transportes de Carga
 */

@ManagedBean
@ViewScoped
public class CreateUsersBean {

    private Long idUser;
    private String firstnameUser;
    private String lastnameUser;
    private String passwordUser;
    private String usernameUser;
    private String emailUser;
    private String telephoneUser;
    private String addressUser;
    private String birthdateUser;
    private int typeUseridtypeuser;
    private String response;
    private List listHandleUsers;
    private List searchListHandleUsers = null;
    private Users user = null;
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

    public List getSearchListHandleUsers(){
        if (searchListHandleUsers == null){
            FacesContext context = FacesContext.getCurrentInstance();
            HandleUsers searchUsers = new HandleUsers();
            Integer typesearch = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("tsearch"));
            String search = context.getExternalContext().getRequestParameterMap().get("dsearch");
            searchListHandleUsers = searchUsers.listManyUsers(typesearch, search);
        }
        return searchListHandleUsers;
    }
    
    public Users getUser(){
        if (user == null){
            FacesContext context = FacesContext.getCurrentInstance();
            HandleUsers updateUsers = new HandleUsers();
            String iduser = context.getExternalContext().getRequestParameterMap().get("iduser");
            user = updateUsers.updateUsers(iduser);
        }
        return user;
    }
    
    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public List getListHandleUsers() {
        HandleUsers listusers = new HandleUsers();
        listHandleUsers = listusers.listAllUsers();
        return listHandleUsers;
    }

    public void setListHandleUsers(List listHandleUsers) {
        this.listHandleUsers = listHandleUsers;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstnameUser() {
        return firstnameUser;
    }

    public void setFirstnameUser(String firstnameUser) {
        this.firstnameUser = firstnameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getTelephoneUser() {
        return telephoneUser;
    }

    public void setTelephoneUser(String telephoneUser) {
        this.telephoneUser = telephoneUser;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getBirthdateUser() {
        return birthdateUser;
    }

    public void setBirthdateUser(String birthdateUser) {
        this.birthdateUser = birthdateUser;
    }

    public int getTypeUseridtypeuser() {
        return typeUseridtypeuser;
    }

    public void setTypeUseridtypeuser(int typeUseridtypeuser) {
        this.typeUseridtypeuser = typeUseridtypeuser;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    public void createUsers() throws ParseException{
        HandleUsers createUsers = new HandleUsers();
        response = createUsers.createUsers(idUser, firstnameUser, lastnameUser, usernameUser,passwordUser, emailUser, telephoneUser, addressUser, birthdateUser, typeUseridtypeuser);
    }

    public String deleteUsers() {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleUsers deleteUsers = new HandleUsers();
        Long pruebanumero = Long.parseLong(context.getExternalContext().getRequestParameterMap().get("iduser"));
        response = deleteUsers.deleteUsers(pruebanumero);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El usuario no existe.");
            context.addMessage(null, message);
            return null;
        } else if (response.equals("err2")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el borrado!",
                    "El usuario esta relacionado con registros de vehìculos.");
            context.addMessage(null, message);
            return null;
        } else {
            return "listUsers";
        }
    }

    public String editUsers() throws ParseException {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleUsers editusers = new HandleUsers();
        Long iduser = Long.parseLong(context.getExternalContext().getRequestParameterMap().get("iduser"));
        String firstnameuser = context.getExternalContext().getRequestParameterMap().get("firstnameuser");
        String lastnameuser = context.getExternalContext().getRequestParameterMap().get("lastnameuser");
        String usernameuser = context.getExternalContext().getRequestParameterMap().get("usernameuser");
        String passworduser = context.getExternalContext().getRequestParameterMap().get("passworduser");
        String emailuser = context.getExternalContext().getRequestParameterMap().get("emailuser");
        String telephoneuser = context.getExternalContext().getRequestParameterMap().get("telephoneuser");
        String addressuser = context.getExternalContext().getRequestParameterMap().get("addressuser");
        String birthdateuser = context.getExternalContext().getRequestParameterMap().get("birthdateuser");
        response = editusers.editUsers(iduser, firstnameuser, lastnameuser, usernameuser, passworduser, emailuser, telephoneuser, addressuser, birthdateuser);
        if (response.equals("no")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló la edición!",
                    "No se pudo guardar la información.");
            context.addMessage(null, message);
            return null;
        } else {
            return "listUsers";
        }
    }

    public String loginUsers() {
        FacesContext context = FacesContext.getCurrentInstance();
        HandleUsers loginUsers = new HandleUsers();
        response = loginUsers.validateUser(usernameUser, passwordUser);
        if (response.equals("err1")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el Login!",
                    "El usuario no existe.");
            context.addMessage(null, message);
            return null;
        } else if (response.equals("err2")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falló el Login!",
                    "El password no es correcto.");
            context.addMessage(null, message);
            return null;
        } else {
            return response;
        }
    }
    
    public String loggoutUsers() {
        String response;
        HandleUsers loggoutUsers = new HandleUsers();
        response = loggoutUsers.logoutUsers();
        return response;
    }

   public String updateUsers(){
        FacesContext context = FacesContext.getCurrentInstance();
        HandleUsers updateUsers = new HandleUsers();
        String iduser = context.getExternalContext().getRequestParameterMap().get("iduser");
        user = updateUsers.updateUsers(iduser);
        if (user == null){
            return "No se encontro el usuario.";
        } else {
            return "editSingleUsers";
        }
    }

    public String searchUsers(){
        return "resultUsers";
    }
    
    public String enableUsers(){
        return "listUsers";
    }
}
