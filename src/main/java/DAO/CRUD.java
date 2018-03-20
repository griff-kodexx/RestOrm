package DAO;
import Entity.User;
import javax.ejb.Local;
import java.util.List;

/**
 * Created by kodexx on 3/14/18.
 */

@Local
public interface CRUD {
    boolean addUser(User user);
    User getById(int id);
    boolean updateUser(User user);
    void delete(User user);
    List<User> getAll();

}
