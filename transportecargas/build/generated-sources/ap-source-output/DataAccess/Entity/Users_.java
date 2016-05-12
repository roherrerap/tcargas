package DataAccess.Entity;

import DataAccess.Entity.Typeusers;
import DataAccess.Entity.Vehicleschedules;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:37:30")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> lastnameUser;
    public static volatile SingularAttribute<Users, String> emailUser;
    public static volatile SingularAttribute<Users, Date> datecreatedUser;
    public static volatile SingularAttribute<Users, Boolean> activeUser;
    public static volatile SingularAttribute<Users, String> passwordUser;
    public static volatile CollectionAttribute<Users, Vehicleschedules> vehicleschedulesCollection;
    public static volatile SingularAttribute<Users, Long> idUser;
    public static volatile SingularAttribute<Users, String> usernameUser;
    public static volatile SingularAttribute<Users, Date> birthdateUser;
    public static volatile SingularAttribute<Users, Typeusers> typeuserIdTypeuser;
    public static volatile SingularAttribute<Users, String> addressUser;
    public static volatile SingularAttribute<Users, String> firstnameUser;
    public static volatile SingularAttribute<Users, String> telephoneUser;

}