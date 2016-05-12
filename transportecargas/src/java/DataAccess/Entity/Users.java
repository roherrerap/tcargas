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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "Users.findByFirstnameUser", query = "SELECT u FROM Users u WHERE u.firstnameUser = :firstnameUser"),
    @NamedQuery(name = "Users.findByLastnameUser", query = "SELECT u FROM Users u WHERE u.lastnameUser = :lastnameUser"),
    @NamedQuery(name = "Users.findByPasswordUser", query = "SELECT u FROM Users u WHERE u.passwordUser = :passwordUser"),
    @NamedQuery(name = "Users.findByUsernameUser", query = "SELECT u FROM Users u WHERE u.usernameUser = :usernameUser"),
    @NamedQuery(name = "Users.findByUsernameUser2", query = "SELECT u FROM Users u WHERE u.usernameUser LIKE ?1"),
    @NamedQuery(name = "Users.findByEmailUser2", query = "SELECT u FROM Users u WHERE u.emailUser LIKE ?1"),
    @NamedQuery(name = "Users.findByEmailUser", query = "SELECT u FROM Users u WHERE u.emailUser = :emailUser"),
    @NamedQuery(name = "Users.findByTelephoneUser", query = "SELECT u FROM Users u WHERE u.telephoneUser = :telephoneUser"),
    @NamedQuery(name = "Users.findByAddressUser", query = "SELECT u FROM Users u WHERE u.addressUser = :addressUser"),
    @NamedQuery(name = "Users.findByBirthdateUser", query = "SELECT u FROM Users u WHERE u.birthdateUser = :birthdateUser"),
    @NamedQuery(name = "Users.findByActiveUser", query = "SELECT u FROM Users u WHERE u.activeUser = :activeUser"),
    @NamedQuery(name = "Users.findByDatecreatedUser", query = "SELECT u FROM Users u WHERE u.datecreatedUser = :datecreatedUser")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private Long idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstname_user")
    private String firstnameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname_user")
    private String lastnameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "password_user")
    private String passwordUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username_user")
    private String usernameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_user")
    private String emailUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telephone_user")
    private String telephoneUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address_user")
    private String addressUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthdate_user")
    @Temporal(TemporalType.DATE)
    private Date birthdateUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active_user")
    private boolean activeUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreated_user")
    @Temporal(TemporalType.DATE)
    private Date datecreatedUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersIdUser")
    private Collection<Vehicleschedules> vehicleschedulesCollection;
    @JoinColumn(name = "typeuser_id_typeuser", referencedColumnName = "id_typeuser")
    @ManyToOne(optional = false)
    private Typeusers typeuserIdTypeuser;

    public Users() {
    }

    public Users(Long idUser) {
        this.idUser = idUser;
    }

    public Users(Long idUser, String firstnameUser, String lastnameUser, String passwordUser, String usernameUser, String emailUser, String telephoneUser, String addressUser, Date birthdateUser, boolean activeUser, Date datecreatedUser) {
        this.idUser = idUser;
        this.firstnameUser = firstnameUser;
        this.lastnameUser = lastnameUser;
        this.passwordUser = passwordUser;
        this.usernameUser = usernameUser;
        this.emailUser = emailUser;
        this.telephoneUser = telephoneUser;
        this.addressUser = addressUser;
        this.birthdateUser = birthdateUser;
        this.activeUser = activeUser;
        this.datecreatedUser = datecreatedUser;
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

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
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

    public Date getBirthdateUser() {
        return birthdateUser;
    }

    public void setBirthdateUser(Date birthdateUser) {
        this.birthdateUser = birthdateUser;
    }

    public boolean getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }

    public Date getDatecreatedUser() {
        return datecreatedUser;
    }

    public void setDatecreatedUser(Date datecreatedUser) {
        this.datecreatedUser = datecreatedUser;
    }

    @XmlTransient
    public Collection<Vehicleschedules> getVehicleschedulesCollection() {
        return vehicleschedulesCollection;
    }

    public void setVehicleschedulesCollection(Collection<Vehicleschedules> vehicleschedulesCollection) {
        this.vehicleschedulesCollection = vehicleschedulesCollection;
    }

    public Typeusers getTypeuserIdTypeuser() {
        return typeuserIdTypeuser;
    }

    public void setTypeuserIdTypeuser(Typeusers typeuserIdTypeuser) {
        this.typeuserIdTypeuser = typeuserIdTypeuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Users[ idUser=" + idUser + " ]";
    }
    
}
