/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.dao;

import entities.inherited.Edible;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Patri Navarro
 */
@Stateless
public class EdibleFacade extends AbstractFacade<Edible> implements EdibleFacadeLocal {

    @PersistenceContext(unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdibleFacade() {
        super(Edible.class);
    }
    
}
