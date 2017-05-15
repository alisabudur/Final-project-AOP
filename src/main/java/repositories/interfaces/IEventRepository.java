package repositories.interfaces;

import domain.Event;

import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public interface IEventRepository {

    List<Event> getAll();
    void save(Event event);
    Event findOne(Integer id);
    void update(Event event);
}
