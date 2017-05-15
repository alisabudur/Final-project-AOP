package mvc.models;

import domain.annotations.UpdateSubject;

/**
 * Created by Alisa on 5/14/2017.
 */
public class EventModel {

    private Integer id;
    private String name;
    private String description;
    private Integer participants;

    public EventModel(Integer id, String name, String description, Integer participants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.participants = participants;
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

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }
}
