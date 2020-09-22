/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.stateful;

import entities.OrderDetail;
import entities.TotalOrder;
import entities.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patri Navarro
 */
@Local
public interface OrderLocal {

    public void initOrder(User user);

    public boolean addOrderDetail(OrderDetail od);

    public boolean removeOrderDetail(OrderDetail od);

    public void remove();
    
    public void purchase();
    
    public List<OrderDetail> getList();
    
    public double getTotal();
    
    //public TotalOrder getTotalOrder();
    //public TotalOrder createOrder(TotalOrder to);

    public void setUser(User user);

    public User getUser();

    public void setList(List<OrderDetail> list);

    public void setTotal(double total);

    public void newOrderList();
    
}
