package mvc.models;

/**
 * Created by Alisa on 5/14/2017.
 */
public class UserModel {

    private Integer id;
    private String name;
    private String eventDescription;

    public UserModel(Integer id, String name, String eventDescription) {
        this.id = id;
        this.name = name;
        this.eventDescription = eventDescription;
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

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
