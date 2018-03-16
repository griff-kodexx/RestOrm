import java.util.List;

/**
 * Created by kodexx on 3/14/18.
 */
public interface CRUD {
    boolean addUser(User user);
    User getById(int id);
    boolean updateUser(User user);
    void delete(User user);
    List<User> getAll();

}
