package BusinessLogic.Controller;

import DataAccess.DAO.UsersDAO;
import DataAccess.DAO.TypeusersDAO;
import DataAccess.Entity.Typeusers;
import DataAccess.Entity.Users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class HandleUsers {

    public static final String USER_SESSION_KEY = "user";
    
    public String createUsers(Long idUser, String firstnameUser, String lastnameUser, String usernameUser, String passwordUser, String emailUser, String telephoneUser, String addressUser, String birthdateUser, int typeUseridtypeuser) throws ParseException{
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date nbirthdateUser = dateformat.parse(birthdateUser);
        Users users = new Users();
        TypeusersDAO typeusersDAO = new TypeusersDAO();
        Typeusers typeuserReceived = typeusersDAO.searchByIdTypeuser(typeUseridtypeuser);
        users.setIdUser(idUser);
        users.setFirstnameUser(firstnameUser);
        users.setLastnameUser(lastnameUser);
        users.setUsernameUser(usernameUser);
        users.setPasswordUser(passwordUser);
        users.setEmailUser(emailUser);
        users.setTelephoneUser(telephoneUser);
        users.setAddressUser(addressUser);
        users.setBirthdateUser(nbirthdateUser);
        users.setActiveUser(true);
        users.setDatecreatedUser(new Date());
        users.setTypeuserIdTypeuser(typeuserReceived);
        UsersDAO usersDAO = new UsersDAO();
        Users usersE = usersDAO.persist(users);
        if (usersE != null) {
            return "El usuario ha sido creado.";
        } else {
            return "El usuario no ha sido creado.";
        }        
    }
    
    public String validateUser(String usernameUser, String passwordUser) {   
        FacesContext context = FacesContext.getCurrentInstance();
        UsersDAO usersDAO = new UsersDAO();
        Users userLogin = usersDAO.searchByUsername(usernameUser);
        if (userLogin != null) {
            if (!userLogin.getPasswordUser().equals(passwordUser)) {
                return "err2";
            }
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, userLogin);
            if (userLogin.getTypeuserIdTypeuser().getIdTypeuser() == 1){
                return "main-admin";
            } else if (userLogin.getTypeuserIdTypeuser().getIdTypeuser() == 2){
                return "main-operator";
            } else {
                return "error-page";
            }
        } else {           
            return "err1";
        }
    }

    public String logoutUsers() {
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "main-index";
    }

    public List listAllUsers(){
        UsersDAO userDAO = new UsersDAO();
        List listTypeusers = null;
        listTypeusers = userDAO.findUsersEntities();
        return listTypeusers;
    }

    public String deleteUsers(Long idUser){
        String response;
        UsersDAO userDAO = new UsersDAO();
        response = userDAO.deleteByIdUser(idUser);
        return response;
    }

    public String editUsers(Long idUser, String firstnameUser, String lastnameUser, String usernameUser, String passwordUser, String emailUser, String telephoneUser, String addressUser, String birthdateUser) throws ParseException{
        String response;
        UsersDAO userDAO = new UsersDAO();
        response = userDAO.editUser(idUser, firstnameUser, lastnameUser, usernameUser, passwordUser, emailUser, telephoneUser, addressUser, birthdateUser);
        return response;
    }

    public List listManyUsers(Integer typesearch, String search){
        UsersDAO usersDAO = new UsersDAO();
        List listUsers = null;
        listUsers = usersDAO.searchUser(typesearch, search);
        return listUsers;
    }
    
    public Users updateUsers (String idUser){
        UsersDAO usersDAO = new UsersDAO();
        Users obusers = null;
        Long iduser = Long.parseLong(idUser);
        obusers = usersDAO.searchByIdUser(iduser);
        return obusers;
    }

}
