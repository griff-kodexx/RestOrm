import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kodexx on 3/14/18.
 */
@Entity
@Table(name = "users")
public class User {
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Id
    @Column(name = "id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*@Override
    public boolean equals(Object obj) {
        User user = (User) obj;

        return this.getId() == user.getId() && this.getPassword() == user.getPassword()
                && this.getName() == user.getName();

    }*/
}