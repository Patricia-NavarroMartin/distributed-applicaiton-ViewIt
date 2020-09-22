package sessionbeans.dao;

import entities.Group;
import entities.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import utils.AuthenticationUtils;

@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    @Override
    public List<String> checkEmail(String email){
        System.out.println("checking email...");
      TypedQuery<String> query = em.createNamedQuery("getUserEmail",String.class);
      query.setParameter("email", email);
      List<String> resultList = query.getResultList();
      return resultList;
      //return query.getSingleResult();
    }
    
            
    @Override
    public List<String> checkPassword(String email){
      System.out.println("checking password...");
      TypedQuery<String> query = em.createNamedQuery("getUserPassword",String.class);
      query.setParameter("email", email);
      List<String> resultList = query.getResultList();
      return resultList;
      //return query.getSingleResult();
    }   
    
    @Override
    public Long getIdFromEmail(String email){
      System.out.println("getting userId...");
      TypedQuery<Long> query = em.createNamedQuery("getUserId",Long.class);
      query.setParameter("email", email);
      Long resultList = query.getResultList().get(0);
      System.out.println("userId = "+resultList);
      return resultList;
    }
    
    
    /*
    // The createUser method first encodes the plain text 
    //password into SHA-256 String, then stores both objects – User and Group to the database.
    @Override
    public void create (User user) {
        try {
            user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,e);
        }
        
        Group group = new Group();
        group.setEmail(user.getEmail());
        group.setGroupname(Group.USERS_GROUP);
        em.persist(user);
        em.persist(group);
        
    }
    
    
    @Override
    public User find(Object id) {
	TypedQuery<User> query = em.createNamedQuery("findUserById", User.class);
	query.setParameter("email", id);
	User user = null;
	try {
		user = query.getSingleResult();
	} catch (Exception e) {
		// getSingleResult throws NoResultException in case there is no user in DB
		// ignore exception and return NULL for user instead
	}
	return user;
    }*/
}
