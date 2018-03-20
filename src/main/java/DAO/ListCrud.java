package DAO;

import Entity.User;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodexx on 3/14/18.
 */
@Stateless(mappedName = "list")
public class ListCrud implements CRUD {

    static List<User> userList = new ArrayList<User>();


    public boolean addUser(User user) {
        userList.add(user);

        if (getById(user.getId())!=null){
            return true;
        }
        return false;
    }

    public User getById(int id) {
        if(userList.size() > 0 ) {
            for (User k : userList) {
                if (k.getId() == id) {
                    return k;
                }
            }
        }
        return null;
    }

    public boolean updateUser(User user) {

        for(int i=0;i<userList.size();i++){
            if (userList.get(i).getId() == user.getId()){
                userList.get(i).setPassword(user.getPassword());
                userList.get(i).setName(user.getName());
            }
        }

       /* Entity.User userToUpdate = getById(user.getId());
        userToUpdate = user;
        delete(user);
        userList.add(userToUpdate);*/

       return userList.contains(user);

        /*for (Entity.User k:userList) {
            if (k==user){
                return true;
            }
        }

        return false;*/

    }

    public void delete(User user) {
       if (userList.size() > 0)
           userList.remove(getById(user.getId()));
    }

    public List<User> getAll() {
        return userList;
    }
}
