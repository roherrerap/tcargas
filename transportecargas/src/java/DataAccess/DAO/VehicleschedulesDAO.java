package DataAccess.DAO;

import DataAccess.Entity.Users;
import DataAccess.Entity.Vehicles;
import DataAccess.Entity.Vehicleschedules;
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
public class VehicleschedulesDAO {

    public EntityManagerFactory emf3 = Persistence.createEntityManagerFactory("transportecargasPU");

    public EntityManager getEntityManager() {
        return emf3.createEntityManager();
    }
    
    public Vehicleschedules persist(Vehicleschedules vehicleshedules) {
        
        EntityManager em = emf3.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(vehicleshedules);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return vehicleshedules;
        }
    }

    public List<Vehicleschedules> findVehicleshedulesEntities() {
        return findVehicleshedulesEntities(true, -1, -1);
    }

    public List<Vehicleschedules> findVehicleshedulesEntities(int maxResults, int firstResult) {
        return findVehicleshedulesEntities(false, maxResults, firstResult);
    }

    private List<Vehicleschedules> findVehicleshedulesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Vehicleschedules as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public String editSchedule(Integer idschedule, String idvehicle, String travel, String timeassigned, String timefinalassigned) throws ParseException{
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date timeAssign = dateformat.parse(timeassigned);
        Date timefinalAssign = dateformat.parse(timefinalassigned);
        VehiclesDAO vehiclesDAO = new VehiclesDAO();
        Vehicles vehicles = vehiclesDAO.searchByIdVehicle(idvehicle);
        EntityManager em = emf3.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("UPDATE Vehicleschedules SET travelassignedVschedule = :travel, "
                    + "timeassignedVschedule = :datetime, timefinalassignedVschedule = :datefinaltime, vehiclesIdVehicle = :vehicle WHERE idVschedule = :idschedule");
            q.setParameter("idschedule", idschedule);
            q.setParameter("travel", travel);
            q.setParameter("datetime", timeAssign);
            q.setParameter("datefinaltime", timefinalAssign);
            q.setParameter("vehicle", vehicles);
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
    
    public String deleteSchedule(Integer idVshedule) {
        EntityManager em = emf3.createEntityManager();
        em.getTransaction().begin();
        String response = "si";
        try {
            Query q = em.createQuery("DELETE FROM Vehicleschedules v WHERE v.idVschedule = :ids");
            q.setParameter("ids", idVshedule);
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

    public List<Vehicles> searchSchedule(Integer typesearch, String search) {
        Vehicles vehicle = null;
        Users user = null;
        EntityManager em = getEntityManager();
        try {
            Query q;
            if (typesearch == 1){
                //search by id vehicle
                q = em.createQuery("SELECT v FROM Vehicles v WHERE v.idVehicle LIKE '%"+search+"%'");
            } else {
                //search by id user
                q = em.createQuery("SELECT v FROM Vehicles v WHERE v.typeVehicle LIKE '%"+search+"%'");
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public Vehicleschedules searchByIdSchedule(String idSchedule) {
        EntityManager em = emf3.createEntityManager();
        Vehicleschedules vehicleschedules = null;
        try {
            vehicleschedules = em.find(Vehicleschedules.class
                    , idSchedule);
        } catch (Exception e){
        } finally {
            em.close();
            return vehicleschedules;
        }
    }

    public List<Vehicleschedules> searchTravel(String travel) {
        EntityManager em = emf3.createEntityManager();
        try {
            Query q;
            q = em.createQuery("SELECT v FROM Vehicleschedules v WHERE v.travelassignedVschedule LIKE '%"+travel+"%'");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Vehicleschedules searchByTravel(String travel) {
        EntityManager em = emf3.createEntityManager();
        Vehicleschedules vehicleschedules = null;
        try {
            Query q = em.createQuery("SELECT v FROM Vehicleschedules v WHERE v.travelassignedVschedule LIKE '%"+travel+"%'");
            vehicleschedules = (Vehicleschedules) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return vehicleschedules;
        }
    }
}
