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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "typeusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeusers.findAll", query = "SELECT t FROM Typeusers t"),
    @NamedQuery(name = "Typeusers.findByIdTypeuser", query = "SELECT t FROM Typeusers t WHERE t.idTypeuser = :idTypeuser"),
    @NamedQuery(name = "Typeusers.findByNameTypeuser", query = "SELECT t FROM Typeusers t WHERE t.nameTypeuser = :nameTypeuser"),
    @NamedQuery(name = "Typeusers.findByDescriptionTypeuser", query = "SELECT t FROM Typeusers t WHERE t.descriptionTypeuser = :descriptionTypeuser"),
    @NamedQuery(name = "Typeusers.findByActiveTypeuser", query = "SELECT t FROM Typeusers t WHERE t.activeTypeuser = :activeTypeuser"),
    @NamedQuery(name = "Typeusers.findByDatecreatedTypeuser", query = "SELECT t FROM Typeusers t WHERE t.datecreatedTypeuser = :datecreatedTypeuser")})
public class Typeusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_typeuser")
    private Integer idTypeuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name_typeuser")
    private String nameTypeuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description_typeuser")
    private String descriptionTypeuser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active_typeuser")
    private boolean activeTypeuser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreated_typeuser")
    @Temporal(TemporalType.DATE)
    private Date datecreatedTypeuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeuserIdTypeuser")
    private Collection<Users> usersCollection;

    public Typeusers() {
    }

    public Typeusers(Integer idTypeuser) {
        this.idTypeuser = idTypeuser;
    }

    public Typeusers(Integer idTypeuser, String nameTypeuser, String descriptionTypeuser, boolean activeTypeuser, Date datecreatedTypeuser) {
        this.idTypeuser = idTypeuser;
        this.nameTypeuser = nameTypeuser;
        this.descriptionTypeuser = descriptionTypeuser;
        this.activeTypeuser = activeTypeuser;
        this.datecreatedTypeuser = datecreatedTypeuser;
    }

    public Integer getIdTypeuser() {
        return idTypeuser;
    }

    public void setIdTypeuser(Integer idTypeuser) {
        this.idTypeuser = idTypeuser;
    }

    public String getNameTypeuser() {
        return nameTypeuser;
    }

    public void setNameTypeuser(String nameTypeuser) {
        this.nameTypeuser = nameTypeuser;
    }

    public String getDescriptionTypeuser() {
        return descriptionTypeuser;
    }

    public void setDescriptionTypeuser(String descriptionTypeuser) {
        this.descriptionTypeuser = descriptionTypeuser;
    }

    public boolean getActiveTypeuser() {
        return activeTypeuser;
    }

    public void setActiveTypeuser(boolean activeTypeuser) {
        this.activeTypeuser = activeTypeuser;
    }

    public Date getDatecreatedTypeuser() {
        return datecreatedTypeuser;
    }

    public void setDatecreatedTypeuser(Date datecreatedTypeuser) {
        this.datecreatedTypeuser = datecreatedTypeuser;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeuser != null ? idTypeuser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeusers)) {
            return false;
        }
        Typeusers other = (Typeusers) object;
        if ((this.idTypeuser == null && other.idTypeuser != null) || (this.idTypeuser != null && !this.idTypeuser.equals(other.idTypeuser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Typeusers[ idTypeuser=" + idTypeuser + " ]";
    }
    
}
