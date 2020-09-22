package entities;

import entities.User;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T16:28:32")
@StaticMetamodel(TotalOrder.class)
public class TotalOrder_ { 

    public static volatile SingularAttribute<TotalOrder, Double> total;
    public static volatile SingularAttribute<TotalOrder, Calendar> createdDate;
    public static volatile SingularAttribute<TotalOrder, Long> orderId;
    public static volatile SingularAttribute<TotalOrder, User> user;

}