package DataAccess.DAO;

import DataAccess.Entity.Users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */

public class UsersDAO {
    
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("transportecargasPU");

    public EntityManager getEntityManager() {
        return emf1.createEntityManager();
    }
    
    public Users persist(Users users) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(users);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return users;  
        }
    }

    public Users searchByIdUser(Long idUser) {
        EntityManager em = emf1.createEntityManager();
        Users users = null;
        try {
            users = em.find(Users.class
                    , idUser);
        } catch (Exception e){
        } finally {
            em.close();
            return users;
        }
    }

    public Users searchByEmail (String emailUser) {
        EntityManager em = emf1.createEntityManager();
        Users users = null;
        Query q = em.createNamedQuery("Users.findByEmailUser2");
        q.setParameter(1, emailUser);
        try {
            users = (Users) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
            return users;
        }
    }

    public Users searchByUsername (String usernameUser) {
        EntityManager em = emf1.createEntityManager();
        Users users = null;
        Query q = em.createNamedQuery("Users.findByUsernameUser2");
        q.setParameter(1, usernameUser);
        try {
            users = (Users) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
            return users;
        }
    }
    
    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
    }

    public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
    }

    private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Users as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public String deleteByIdUser(Long idUser) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("DELETE FROM Users u WHERE u.idUser = :idu");
            q.setParameter("idu", idUser);
            q.executeUpdate();
        } catch (Exception e) {
            em.getTransaction().setRollbackOnly();
            response = "no";
        } finally {
            em.getTransaction().commit();
            em.close();
            return response;
        }
    }

    public String editUser(Long idUser, String firstnameUser, String lastnameUser, String usernameUser, String passwordUser, String emailUser, String telephoneUser, String addressUser, String birthdateUser) throws ParseException{
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date nbirthdateUser = dateformat.parse(birthdateUser);
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("UPDATE Users SET firstnameUser = :firstname, lastnameUser = :lastname, "
                    + "usernameUser = :username, passwordUser = :password, emailUser = :email, telephoneUser = :telephone, "
                    + "addressUser = :address, birthdateUser = :birthdate WHERE idUser = :id");
            q.setParameter("id", idUser);
            q.setParameter("firstname", firstnameUser);
            q.setParameter("lastname", lastnameUser);
            q.setParameter("username", usernameUser);
            q.setParameter("password", passwordUser);
            q.setParameter("email", emailUser);
            q.setParameter("telephone", telephoneUser);
            q.setParameter("address", addressUser);
            q.setParameter("birthdate", nbirthdateUser);
            q.executeUpdate();
        } catch (Exception e) {
            em.getTransaction().setRollbackOnly();
            response = "no";
        } finally {
            em.getTransaction().commit();
            em.close();
            return response;
        }
    }

    public List<Users> searchUser(Integer typesearch, String search) {
        EntityManager em = getEntityManager();
        try {
            Query q;
            if (typesearch == 1){
                Long idUser = Long.parseLong(search);
                q = em.createQuery("SELECT u FROM Users u WHERE u.idUser = :id");
                q.setParameter("id", idUser);
            } else if (typesearch == 2){
                q = em.createQuery("SELECT u FROM Users u WHERE u.firstnameUser LIKE '%"+search+"%'");
            } else if (typesearch == 3){
                q = em.createQuery("SELECT u FROM Users u WHERE u.lastnameUser LIKE '%"+search+"%'");
            } else {
                q = em.createQuery("SELECT u FROM Users u WHERE u.usernameUser LIKE '%"+search+"%'");
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
