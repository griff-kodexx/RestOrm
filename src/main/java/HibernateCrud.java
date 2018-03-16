
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by kodexx on 3/15/18.
 */

@RequestScoped
@Named("jpa")
public class HibernateCrud implements CRUD {
    private static EntityManager entityManager = null;

    public HibernateCrud() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
        if (entityManager == null){
            entityManager = emf.createEntityManager();
        }
    }

    public boolean addUser(User user) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public User getById(int id) {
        User u;
        try{
            u = entityManager.find(User.class, id);
        }catch(Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex.getMessage());
            return null;
        }
        return u;

    }

    public boolean updateUser(User user) {
        return false;
    }

    public void delete(User user) {

    }

    public List<User> getAll() {
        return null;
    }
}
