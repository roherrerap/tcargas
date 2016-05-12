package DataAccess.DAO;

import DataAccess.Entity.Typeusers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class TypeusersDAO {

    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("transportecargasPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Typeusers persist(Typeusers typeusers) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(typeusers);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return typeusers;  
        }
    }

    public Typeusers searchByIdTypeuser(Integer idTypeuser) {
        EntityManager em = emf.createEntityManager();
        Typeusers t = null;
        try {
            t = em.find(Typeusers.class
                    , idTypeuser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return t;
        }
    }

    public String deleteByIdTypeuser(Integer idTypeuser) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("DELETE FROM Typeusers t WHERE t.idTypeuser = :id");
            q.setParameter("id", idTypeuser);
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
    
    public List<Typeusers> findTypeusersEntities() {
        return findTypeusersEntities(true, -1, -1);
    }

    public List<Typeusers> findTypeusersEntities(int maxResults, int firstResult) {
        return findTypeusersEntities(false, maxResults, firstResult);
    }

    private List<Typeusers> findTypeusersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Typeusers as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Typeusers> searchTypeuser(Integer typesearch, String search) {
        EntityManager em = getEntityManager();
        try {
            Query q;
            if (typesearch == 1){
                q = em.createQuery("SELECT t FROM Typeusers t WHERE t.idTypeuser = :search");
                q.setParameter("search", Integer.parseInt(search));
            } else {
                q = em.createQuery("SELECT t FROM Typeusers t WHERE t.nameTypeuser LIKE '%"+search+"%'");
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public String editTypeuser(Integer idTypeuser, String nameTypeuser, String descriptionTypeuser) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("UPDATE Typeusers SET nameTypeuser = :name, descriptionTypeuser = :description WHERE idTypeuser = :id");
            q.setParameter("id", idTypeuser);
            q.setParameter("name", nameTypeuser);
            q.setParameter("description", descriptionTypeuser);
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
}
