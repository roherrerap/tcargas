package DataAccess.Entity;

import DataAccess.Entity.Vehicleschedules;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-16T20:58:07")
@StaticMetamodel(Vehicles.class)
public class Vehicles_ { 

    public static volatile SingularAttribute<Vehicles, Integer> modelyearVehicle;
    public static volatile SingularAttribute<Vehicles, Boolean> activeVehicle;
    public static volatile SingularAttribute<Vehicles, String> idVehicle;
    public static volatile SingularAttribute<Vehicles, String> brandVehicle;
    public static volatile SingularAttribute<Vehicles, Date> datecreatedVehicle;
    public static volatile SingularAttribute<Vehicles, String> typeVehicle;
    public static volatile CollectionAttribute<Vehicles, Vehicleschedules> vehicleschedulesCollection;
    public static volatile SingularAttribute<Vehicles, String> colorVehicle;

}