/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.dao;

import entities.inherited.Edible;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patri Navarro
 */
@Local
public interface EdibleFacadeLocal {

    Edible create(Edible edible);

    void edit(Edible edible);

    void remove(Edible edible);

    Edible find(Object id);

    List<Edible> findAll();

    List<Edible> findRange(int[] range);

    int count();
    
}
