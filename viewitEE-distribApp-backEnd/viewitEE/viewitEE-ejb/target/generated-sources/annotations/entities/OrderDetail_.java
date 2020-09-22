package entities;

import entities.Product;
import entities.TotalOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T16:28:32")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Product> product;
    public static volatile SingularAttribute<OrderDetail, Double> orderDetailPrice;
    public static volatile SingularAttribute<OrderDetail, Integer> quantity;
    public static volatile SingularAttribute<OrderDetail, Long> orderDetailId;
    public static volatile SingularAttribute<OrderDetail, TotalOrder> order;

}