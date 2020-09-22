package services;

import entities.OrderDetail;
import entities.TotalOrder;
import interceptors.LoggerInterceptor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sessionbeans.dao.TotalOrderFacadeLocal;
import sessionbeans.stateful.OrderLocal;

@Path("/order")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
@Interceptors(LoggerInterceptor.class)
public class OrderRest {
    @Context 
    private UriInfo uriInfo;
    @PersistenceContext (unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;
    
    @EJB
    private OrderLocal order;
    
    @EJB
    private TotalOrderFacadeLocal totalOrderFacade;
    
    @POST
    @Path("/addOrderDetail")
    public OrderDetail addOrderDetail (OrderDetail od){
        System.out.println("Received od with product id: " + od.getProduct().getProductId());
        System.out.println("and quantity: " + od.getQuantity());
        od.setOrderDetailPrice(od.getProduct().getUnitPrice()*od.getQuantity());
        order.addOrderDetail(od);
        return od;
    }
    
    
    @GET
    @Path("/orderList")
    public List<OrderDetail> getOrderList () {
        return order.getList();
    }
    
    @GET
    @Path("/purchase")
    public void purchaseOrder(){
        //return order.purchase();
        order.purchase();
    }
    /*
    @POST
    @Path("/order/createOrder")
    public TotalOrder createOrder(TotalOrder totalOrder){
        return order.createOrder(totalOrder);
    }*/
    
    @GET
    @Path("/all")
    public List<TotalOrder> getAllOrders(){
        return totalOrderFacade.findAll();
    }
    
}
