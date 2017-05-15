package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public class Event {

    private Integer id;
    private String name;
    private String description;
    private List<User> users;

    public Event(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Event(Integer id, String name, String description, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        setUsers(users);
    }

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        users.forEach(u -> addUser(u));
    }

    public void addUser(User user){
        if(users == null)
            users = new ArrayList<>();
        users.add(user);
    }

    public void removeUser(User user){
        try{
            users.remove(user);
        }
        catch (Exception e){

        }
    }
}
