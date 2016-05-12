package DataAccess.DAO;

import DataAccess.Entity.Vehicles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class VehiclesDAO {

    public EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("transportecargasPU");

    public EntityManager getEntityManager() {
        return emf2.createEntityManager();
    }
    
    public Vehicles persist(Vehicles vehicles) {
        EntityManager em = emf2.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(vehicles);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return vehicles;  
        }
    }

    public Vehicles searchByIdVehicle(String idVehicle) {
        EntityManager em = emf2.createEntityManager();
        Vehicles vehicles = null;
        try {
            vehicles = em.find(Vehicles.class
                    , idVehicle);
        } catch (Exception e){
        } finally {
            em.close();
            return vehicles;
        }
    }
    
    public Vehicles searchByModelYearVehicle (int modelyearVehicle) {
        EntityManager em = emf2.createEntityManager();
        Vehicles vehicles = null;
        Query q = em.createNamedQuery("Vehiculo.findByYear");
        q.setParameter(1, modelyearVehicle);
        try {
            vehicles = (Vehicles) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
            return vehicles;
        }
    }

    public Vehicles searchByTypeVehicle (String typeVehicle) {
        EntityManager em = emf2.createEntityManager();
        Vehicles vehicles = null;
        Query q = em.createNamedQuery("Vehiculo.findByTipoVehiculo");
        q.setParameter(1, typeVehicle);
        try {
            vehicles = (Vehicles) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
            return vehicles;
        }
    }

    public List<Vehicles> findVehiclesEntities() {
        return findVehiclesEntities(true, -1, -1);
    }

    public List<Vehicles> findVehiclesEntities(int maxResults, int firstResult) {
        return findVehiclesEntities(false, maxResults, firstResult);
    }

    private List<Vehicles> findVehiclesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Vehicles as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public String deleteByIdVehicle (String idVehicle) {
        EntityManager em = emf2.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("DELETE FROM Vehicles v WHERE v.idVehicle = :idv");
            q.setParameter("idv", idVehicle);
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

    public String editVehicle(String idVehicle, String colorVehicle, int modelyearVehicle, String typeVehicle, String brandVehicle) {
        EntityManager em = emf2.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("UPDATE Vehicles SET colorVehicle = :color, modelyearVehicle = :model, typeVehicle = :type, brandVehicle = :brand WHERE idVehicle LIKE :id");
            q.setParameter("id", idVehicle);
            q.setParameter("color", colorVehicle);
            q.setParameter("model", modelyearVehicle);
            q.setParameter("type", typeVehicle);
            q.setParameter("brand", brandVehicle);
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

    public List<Vehicles> searchVehicle(Integer typesearch, String search) {
        EntityManager em = getEntityManager();
        try {
            Query q;
            if (typesearch == 1){
                q = em.createQuery("SELECT v FROM Vehicles v WHERE v.idVehicle LIKE '%"+search+"%'");
            } else if (typesearch == 2){
                q = em.createQuery("SELECT v FROM Vehicles v WHERE v.colorVehicle LIKE '%"+search+"%'");
            } else {
                q = em.createQuery("SELECT v FROM Vehicles v WHERE v.typeVehicle LIKE '%"+search+"%'");
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
}
