package mvc.controllers.interfaces;

import mvc.models.EventModel;
import mvc.models.EventTableModel;

import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public interface IEventController {
    List<EventModel> getAll() throws Exception;
    void save(EventModel event) throws Exception;
    EventModel findOne(Integer id) throws Exception;
    EventTableModel getEventTableModel() throws Exception;
    String getSelectedEvent(Integer index) throws Exception;
    void update(Integer id, String description) throws Exception;
    void refreshEventTableModel() throws Exception;

}
