package domain;

import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public class User {

    private Integer id;
    private String name;
    private Integer eventId;


    public User(Integer id, String name, Integer eventId) {
        this.id = id;
        this.name = name;
        this.eventId = eventId;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
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

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}
