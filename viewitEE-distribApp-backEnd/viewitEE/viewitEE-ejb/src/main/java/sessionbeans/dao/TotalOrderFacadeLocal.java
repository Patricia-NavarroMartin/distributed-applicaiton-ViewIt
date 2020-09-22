/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.dao;

import entities.TotalOrder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patri Navarro
 */
@Local
public interface TotalOrderFacadeLocal {

    TotalOrder create(TotalOrder totalOrder);

    void edit(TotalOrder totalOrder);

    void remove(TotalOrder totalOrder);

    TotalOrder find(Object id);

    List<TotalOrder> findAll();

    List<TotalOrder> findRange(int[] range);

    int count();
    
}
