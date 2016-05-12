/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Familiar
 */
@Entity
@Table(name = "vehicles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicles.findAll", query = "SELECT v FROM Vehicles v"),
    @NamedQuery(name = "Vehicles.findByIdVehicle", query = "SELECT v FROM Vehicles v WHERE v.idVehicle = :idVehicle"),
    @NamedQuery(name = "Vehicles.findByColorVehicle", query = "SELECT v FROM Vehicles v WHERE v.colorVehicle = :colorVehicle"),
    @NamedQuery(name = "Vehicles.findByModelyearVehicle", query = "SELECT v FROM Vehicles v WHERE v.modelyearVehicle = :modelyearVehicle"),
    @NamedQuery(name = "Vehicles.findByTypeVehicle", query = "SELECT v FROM Vehicles v WHERE v.typeVehicle = :typeVehicle"),
    @NamedQuery(name = "Vehicles.findByBrandVehicle", query = "SELECT v FROM Vehicles v WHERE v.brandVehicle = :brandVehicle"),
    @NamedQuery(name = "Vehicles.findByActiveVehicle", query = "SELECT v FROM Vehicles v WHERE v.activeVehicle = :activeVehicle"),
    @NamedQuery(name = "Vehicles.findByDatecreatedVehicle", query = "SELECT v FROM Vehicles v WHERE v.datecreatedVehicle = :datecreatedVehicle")})
public class Vehicles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_vehicle")
    private String idVehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "color_vehicle")
    private String colorVehicle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelyear_vehicle")
    private int modelyearVehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "type_vehicle")
    private String typeVehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "brand_vehicle")
    private String brandVehicle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active_vehicle")
    private boolean activeVehicle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreated_vehicle")
    @Temporal(TemporalType.DATE)
    private Date datecreatedVehicle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiclesIdVehicle")
    private Collection<Vehicleschedules> vehicleschedulesCollection;

    public Vehicles() {
    }

    public Vehicles(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public Vehicles(String idVehicle, String colorVehicle, int modelyearVehicle, String typeVehicle, String brandVehicle, boolean activeVehicle, Date datecreatedVehicle) {
        this.idVehicle = idVehicle;
        this.colorVehicle = colorVehicle;
        this.modelyearVehicle = modelyearVehicle;
        this.typeVehicle = typeVehicle;
        this.brandVehicle = brandVehicle;
        this.activeVehicle = activeVehicle;
        this.datecreatedVehicle = datecreatedVehicle;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getColorVehicle() {
        return colorVehicle;
    }

    public void setColorVehicle(String colorVehicle) {
        this.colorVehicle = colorVehicle;
    }

    public int getModelyearVehicle() {
        return modelyearVehicle;
    }

    public void setModelyearVehicle(int modelyearVehicle) {
        this.modelyearVehicle = modelyearVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getBrandVehicle() {
        return brandVehicle;
    }

    public void setBrandVehicle(String brandVehicle) {
        this.brandVehicle = brandVehicle;
    }

    public boolean getActiveVehicle() {
        return activeVehicle;
    }

    public void setActiveVehicle(boolean activeVehicle) {
        this.activeVehicle = activeVehicle;
    }

    public Date getDatecreatedVehicle() {
        return datecreatedVehicle;
    }

    public void setDatecreatedVehicle(Date datecreatedVehicle) {
        this.datecreatedVehicle = datecreatedVehicle;
    }

    @XmlTransient
    public Collection<Vehicleschedules> getVehicleschedulesCollection() {
        return vehicleschedulesCollection;
    }

    public void setVehicleschedulesCollection(Collection<Vehicleschedules> vehicleschedulesCollection) {
        this.vehicleschedulesCollection = vehicleschedulesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicle != null ? idVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicles)) {
            return false;
        }
        Vehicles other = (Vehicles) object;
        if ((this.idVehicle == null && other.idVehicle != null) || (this.idVehicle != null && !this.idVehicle.equals(other.idVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Vehicles[ idVehicle=" + idVehicle + " ]";
    }
    
}
