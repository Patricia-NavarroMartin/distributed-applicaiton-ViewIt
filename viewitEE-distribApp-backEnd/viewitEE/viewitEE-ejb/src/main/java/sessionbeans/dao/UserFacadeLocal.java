package sessionbeans.dao;

import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserFacadeLocal {

    User create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
    public List<String> checkEmail(String email);
    public List<String> checkPassword(String email);
    public Long getIdFromEmail(String email);
}
