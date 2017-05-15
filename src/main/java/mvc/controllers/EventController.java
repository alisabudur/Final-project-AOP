package mvc.controllers;

import domain.Event;
import domain.annotations.UpdateSubject;
import mvc.controllers.interfaces.IEventController;
import mvc.models.EventModel;
import mvc.models.EventTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.interfaces.IEventRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alisa on 5/14/2017.
 */
public class EventController implements IEventController {

    @Autowired
    private IEventRepository eventRepository;

    private EventTableModel eventTableModel;

    @Override
    public void save(EventModel eventModel) throws Exception {
        try {
            Event event = new Event(eventModel.getId(), eventModel.getName(), eventModel.getDescription());
            eventRepository.save(event);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public List<EventModel> getAll() throws Exception {
        try {
            List<Event> dbEvents = eventRepository.getAll();
            List<EventModel> events = dbEvents
                    .stream()
                    .map(e -> new EventModel(e.getId(), e.getName(), e.getDescription(), e.getUsers().size()))
                    .collect(Collectors.toList());
            return events;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public EventModel findOne(Integer id) throws Exception {
        try {
            Event event = eventRepository.findOne(id);
            EventModel eventModel = new EventModel(event.getId(), event.getName(), event.getDescription(), event.getUsers().size());
            return eventModel;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public EventTableModel getEventTableModel() throws Exception {
        if(eventTableModel == null)
            eventTableModel = new EventTableModel(getAll());
        return eventTableModel;
    }

    @Override
    public String getSelectedEvent(Integer index) throws Exception {
        String id = getAll().get(index).getId().toString();
        return id;
    }

    @Override
    public void update(Integer id, String description) throws Exception {
        try {
            EventModel eventModel = findOne(id);
            eventModel.setDescription(description);
            Event event = new Event(eventModel.getId(), eventModel.getName(), eventModel.getDescription());
            eventRepository.update(event);
            eventTableModel.setEvents(getAll());
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public void refreshEventTableModel() throws Exception {
        eventTableModel.setEvents(getAll());
    }

    public IEventRepository getEventRepository() {
        return eventRepository;
    }

    public void setEventRepository(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
