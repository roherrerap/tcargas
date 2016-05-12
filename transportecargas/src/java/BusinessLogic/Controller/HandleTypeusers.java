package BusinessLogic.Controller;

import DataAccess.DAO.TypeusersDAO;
import DataAccess.Entity.Typeusers;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class HandleTypeusers {
 
    public String createTypeUser(String nameTypeuser, String descriptionTypeuser){
        Typeusers typeusers = new Typeusers();
        typeusers.setNameTypeuser(nameTypeuser);
        typeusers.setDescriptionTypeuser(descriptionTypeuser);
        typeusers.setActiveTypeuser(true);
        typeusers.setDatecreatedTypeuser(new Date());
        TypeusersDAO typeusersDAO = new TypeusersDAO();
        Typeusers typeusersE = typeusersDAO.persist(typeusers);
        if (typeusersE != null) {
            return "El tipo de usuario ha sido creado, con el identificador: " + typeusers.getIdTypeuser() + ".";
        } else {
            return "El tipo de usuario no pudo ser creado.";
        }        
    }
    
    public List listAllTypeusers(){
        TypeusersDAO TypeuserDAO = new TypeusersDAO();
        List listTypeusers = null;
        listTypeusers = TypeuserDAO.findTypeusersEntities();
        return listTypeusers;
    }
    
    public String deleteTypeusers(Integer idTypeuser){
        String response;
        TypeusersDAO typeuserDAO = new TypeusersDAO();
        response = typeuserDAO.deleteByIdTypeuser(idTypeuser);
        return response;
    }

    public String editTypeusers(Integer idTypeuser, String nameTypeuser, String descriptionTypeuser){
        String response;
        TypeusersDAO typeuserDAO = new TypeusersDAO();
        response = typeuserDAO.editTypeuser(idTypeuser, nameTypeuser, descriptionTypeuser);
        return response;
    }

    public List listManyTypeusers(Integer typesearch, String search){
        TypeusersDAO TypeuserDAO = new TypeusersDAO();
        List listTypeusers = null;
        listTypeusers = TypeuserDAO.searchTypeuser(typesearch, search);
        return listTypeusers;
    }
    
    public Typeusers updateTypeusers (Integer idTypeuser){
        TypeusersDAO typeuserDAO = new TypeusersDAO();
        Typeusers obtypeusers = null;
        obtypeusers = typeuserDAO.searchByIdTypeuser(idTypeuser);
        return obtypeusers;
    }
}
