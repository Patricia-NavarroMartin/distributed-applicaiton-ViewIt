/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.dao;

import entities.OrderDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patri Navarro
 */
@Local
public interface OrderDetailFacadeLocal {

    OrderDetail create(OrderDetail orderDetail);

    void edit(OrderDetail orderDetail);

    void remove(OrderDetail orderDetail);

    OrderDetail find(Object id);

    List<OrderDetail> findAll();

    List<OrderDetail> findRange(int[] range);

    int count();
    
}
