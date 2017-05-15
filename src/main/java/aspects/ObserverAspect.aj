package aspects;
import domain.observer.Observer;
import domain.observer.Subject;
import mvc.controllers.EventController;
import mvc.models.EventTableModel;
import mvc.views.AbstractEntityView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Alisa on 5/14/2017.
 */
public aspect ObserverAspect {
    declare parents:EventTableModel implements Subject;
    declare parents:AbstractEntityView implements Observer;
    private static Logger logger = Logger.getLogger("Observer");

    pointcut toNotify(EventTableModel eventTableModel):execution(@domain.annotations.UpdateSubject * *(..)) && this(eventTableModel);
    pointcut toAddObserver(EventController eventController, AbstractEntityView view): initialization(mvc.views.AbstractEntityView.new(*)) && args(eventController) && this(view);
//    pointcut toRemoveObserver(Event event, User user):execution(* domain.Event.removeUser(..)) && this(event) && args(user);

    private List<Observer> Subject.observers = new ArrayList<>();

    public void Subject.addObserver(Observer obs) {
        logger.info("Adding observer");
        observers.add(obs);
    }
    public void Subject.removeObserver(Observer obs) {
        logger.info("Removing observer");
        observers.remove(obs);

    }
    public void Subject.notifyObservers(Object o) {
        logger.info("Notifying observers");
        for (Observer ob : observers)
            ob.update(o);
    }

    public void AbstractEntityView.update(Object o) throws Exception {
        logger.info("Observer: update");
        refreshView();
    }

    after(EventTableModel eventTableModel) returning: toNotify(eventTableModel){
        logger.info("Subject: notifyObservers");
        eventTableModel.notifyObservers(null);
    }

    after(EventController eventController, AbstractEntityView view): toAddObserver(eventController, view){
        logger.info("Subject: add observer");
        try {
            eventController.getEventTableModel().addObserver(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    after(Event event, User user): toRemoveObserver(event, user){
//        System.out.println("Subject: remove observer");
//        event.removeObserver(user);
//    }
}
