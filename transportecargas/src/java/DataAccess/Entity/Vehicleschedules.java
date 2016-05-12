/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
@Entity
@Table(name = "vehicleschedules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicleschedules.findAll", query = "SELECT v FROM Vehicleschedules v"),
    @NamedQuery(name = "Vehicleschedules.findByIdVschedule", query = "SELECT v FROM Vehicleschedules v WHERE v.idVschedule = :idVschedule"),
    @NamedQuery(name = "Vehicleschedules.findByTravelassignedVschedule", query = "SELECT v FROM Vehicleschedules v WHERE v.travelassignedVschedule = :travelassignedVschedule"),
    @NamedQuery(name = "Vehicleschedules.findByTravelassignedVschedule2", query = "SELECT v FROM Vehicleschedules v WHERE v.travelassignedVschedule LIKE ?1"),
    @NamedQuery(name = "Vehicleschedules.findByTimeassignedVschedule", query = "SELECT v FROM Vehicleschedules v WHERE v.timeassignedVschedule = :timeassignedVschedule"),
    @NamedQuery(name = "Vehicleschedules.findByTimefinalassignedVschedule", query = "SELECT v FROM Vehicleschedules v WHERE v.timefinalassignedVschedule = :timefinalassignedVschedule"),
    @NamedQuery(name = "Vehicleschedules.findByActiveVschedule", query = "SELECT v FROM Vehicleschedules v WHERE v.activeVschedule = :activeVschedule"),
    @NamedQuery(name = "Vehicleschedules.findByDatecreatedVschedule", query = "SELECT v FROM Vehicleschedules v WHERE v.datecreatedVschedule = :datecreatedVschedule")})
public class Vehicleschedules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vschedule")
    private Integer idVschedule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "travelassigned_vschedule")
    private String travelassignedVschedule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeassigned_vschedule")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeassignedVschedule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timefinalassigned_vschedule")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timefinalassignedVschedule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active_vschedule")
    private boolean activeVschedule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreated_vschedule")
    @Temporal(TemporalType.DATE)
    private Date datecreatedVschedule;
    @JoinColumn(name = "users_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Users usersIdUser;
    @JoinColumn(name = "vehicles_id_vehicle", referencedColumnName = "id_vehicle")
    @ManyToOne(optional = false)
    private Vehicles vehiclesIdVehicle;

    public Vehicleschedules() {
    }

    public Vehicleschedules(Integer idVschedule) {
        this.idVschedule = idVschedule;
    }

    public Vehicleschedules(Integer idVschedule, String travelassignedVschedule, Date timeassignedVschedule, Date timefinalassignedVschedule, boolean activeVschedule, Date datecreatedVschedule) {
        this.idVschedule = idVschedule;
        this.travelassignedVschedule = travelassignedVschedule;
        this.timeassignedVschedule = timeassignedVschedule;
        this.timefinalassignedVschedule = timefinalassignedVschedule;
        this.activeVschedule = activeVschedule;
        this.datecreatedVschedule = datecreatedVschedule;
    }

    public Integer getIdVschedule() {
        return idVschedule;
    }

    public void setIdVschedule(Integer idVschedule) {
        this.idVschedule = idVschedule;
    }

    public String getTravelassignedVschedule() {
        return travelassignedVschedule;
    }

    public void setTravelassignedVschedule(String travelassignedVschedule) {
        this.travelassignedVschedule = travelassignedVschedule;
    }

    public Date getTimeassignedVschedule() {
        return timeassignedVschedule;
    }

    public void setTimeassignedVschedule(Date timeassignedVschedule) {
        this.timeassignedVschedule = timeassignedVschedule;
    }

    public Date getTimefinalassignedVschedule() {
        return timefinalassignedVschedule;
    }

    public void setTimefinalassignedVschedule(Date timefinalassignedVschedule) {
        this.timefinalassignedVschedule = timefinalassignedVschedule;
    }

    public boolean getActiveVschedule() {
        return activeVschedule;
    }

    public void setActiveVschedule(boolean activeVschedule) {
        this.activeVschedule = activeVschedule;
    }

    public Date getDatecreatedVschedule() {
        return datecreatedVschedule;
    }

    public void setDatecreatedVschedule(Date datecreatedVschedule) {
        this.datecreatedVschedule = datecreatedVschedule;
    }

    public Users getUsersIdUser() {
        return usersIdUser;
    }

    public void setUsersIdUser(Users usersIdUser) {
        this.usersIdUser = usersIdUser;
    }

    public Vehicles getVehiclesIdVehicle() {
        return vehiclesIdVehicle;
    }

    public void setVehiclesIdVehicle(Vehicles vehiclesIdVehicle) {
        this.vehiclesIdVehicle = vehiclesIdVehicle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVschedule != null ? idVschedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicleschedules)) {
            return false;
        }
        Vehicleschedules other = (Vehicleschedules) object;
        if ((this.idVschedule == null && other.idVschedule != null) || (this.idVschedule != null && !this.idVschedule.equals(other.idVschedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Vehicleschedules[ idVschedule=" + idVschedule + " ]";
    }
    
}
