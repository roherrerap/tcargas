package DataAccess.Entity;

import DataAccess.Entity.Users;
import DataAccess.Entity.Vehicles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:37:30")
@StaticMetamodel(Vehicleschedules.class)
public class Vehicleschedules_ { 

    public static volatile SingularAttribute<Vehicleschedules, Integer> idVschedule;
    public static volatile SingularAttribute<Vehicleschedules, Date> timeassignedVschedule;
    public static volatile SingularAttribute<Vehicleschedules, Date> timefinalassignedVschedule;
    public static volatile SingularAttribute<Vehicleschedules, Date> datecreatedVschedule;
    public static volatile SingularAttribute<Vehicleschedules, Vehicles> vehiclesIdVehicle;
    public static volatile SingularAttribute<Vehicleschedules, String> travelassignedVschedule;
    public static volatile SingularAttribute<Vehicleschedules, Boolean> activeVschedule;
    public static volatile SingularAttribute<Vehicleschedules, Users> usersIdUser;

}