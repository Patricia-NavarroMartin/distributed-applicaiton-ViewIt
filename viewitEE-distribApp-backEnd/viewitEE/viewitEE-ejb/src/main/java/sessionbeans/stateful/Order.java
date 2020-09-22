package sessionbeans.stateful;

import entities.OrderDetail;
import entities.TotalOrder;
import entities.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sessionbeans.dao.OrderDetailFacadeLocal;
import sessionbeans.dao.TotalOrderFacadeLocal;
import sessionbeans.dao.UserFacadeLocal;
import sessionbeans.singleton.TheLogger;

@Stateful
public class Order implements OrderLocal {

    private User user;
    private List<OrderDetail> list;//= new ArrayList<>();
    private double total;
    @EJB
    private TotalOrderFacadeLocal totalOrderFacade;
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private OrderDetailFacadeLocal orderDetailFacade;
    @PersistenceContext (unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;
    
    @Override
    public void initOrder(User user) {
        this.user = user;
        this.list = new ArrayList<>();
        //this.newOrderList();
        this.total = 0;
    }
    
    @Override
    public void newOrderList(){
        //if(!this.list.isEmpty()) remove();
        this.list = new ArrayList<>();
    }
    
    @Override
    public boolean addOrderDetail(OrderDetail od) {
        list.add(od);
        total = total + od.getOrderDetailPrice();
        return true;
    }
    
    @Override
    public boolean removeOrderDetail (OrderDetail od) {
        boolean result = list.remove(od);
        if (result == false){
            TheLogger.getLog().log(Level.WARNING, "Product {0} is not in the order list", od.getProduct().getProductId());
            return false;
        }
        return true;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public List<OrderDetail> getList() {
        return list;
    }

    @Override
    public void setList(List<OrderDetail> list) {
        this.list = list;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void setTotal(double total) {
        this.total = total;
    }
/*
    public TotalOrder getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(TotalOrder totalOrder) {
        this.totalOrder = totalOrder;
    }
    */
    
    
    @Remove
    @Override
    public void remove() {
        user = null;
        list = null;
    }
    
    @Override
    //@EJB(beanName="entities.TotalOrder")
    public void purchase(){
        //Generate a new totalOrder and persist it in the database
        TotalOrder totalOrder = new TotalOrder();
        totalOrder.setCreatedDate(Calendar.getInstance());
        //System.out.println("User id = "+user.getUserId());
        totalOrder.setUser(user);
        
        totalOrder.setTotal(total);
        totalOrder = totalOrderFacade.create(totalOrder);
        
        //Once order has been registered it will have an id to be referenced to
        // the order details, so we update the created totalOrder setting the list
        for (OrderDetail od: list){
            od.setOrder(totalOrder);
            od = orderDetailFacade.create(od);
        }
        /**/
        //Once purchased we reset the list
        //remove();
        newOrderList();
    }
    /*
    @Override
    @EJB(beanName="entities.TotalOrder")
    public TotalOrder createOrder(TotalOrder to){
        return totalOrderFacade.create(to);
    }*/
    /*
    // Entity bean defined at the beginning but only injected here
    @EJB(beanName="entities.TotalOrder")
    private TotalOrder buildTotalOrder(){
        totalOrder.setCreatedDate(Calendar.getInstance());
        totalOrder.setUser(user);
        totalOrder.setOrderDetails(list);
        totalOrder.setTotal(total);
        return totalOrder;
    }*/
}
