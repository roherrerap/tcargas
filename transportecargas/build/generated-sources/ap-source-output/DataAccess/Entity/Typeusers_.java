package DataAccess.Entity;

import DataAccess.Entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:37:30")
@StaticMetamodel(Typeusers.class)
public class Typeusers_ { 

    public static volatile SingularAttribute<Typeusers, Integer> idTypeuser;
    public static volatile SingularAttribute<Typeusers, Date> datecreatedTypeuser;
    public static volatile SingularAttribute<Typeusers, String> descriptionTypeuser;
    public static volatile SingularAttribute<Typeusers, String> nameTypeuser;
    public static volatile CollectionAttribute<Typeusers, Users> usersCollection;
    public static volatile SingularAttribute<Typeusers, Boolean> activeTypeuser;

}