/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.dao;

import entities.inherited.Ticket;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patri Navarro
 */
@Local
public interface TicketFacadeLocal {

    Ticket create(Ticket ticket);

    void edit(Ticket ticket);

    void remove(Ticket ticket);

    Ticket find(Object id);

    List<Ticket> findAll();

    List<Ticket> findRange(int[] range);

    int count();
    
}
