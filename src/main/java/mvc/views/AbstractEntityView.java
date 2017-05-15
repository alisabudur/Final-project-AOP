package mvc.views;

import mvc.controllers.EventController;

/**
 * Created by Alisa on 5/14/2017.
 */
public abstract class AbstractEntityView {
    protected EventController eventController;

    public AbstractEntityView(EventController eventController) {
        this.eventController = eventController;
    }

    public abstract void refreshView() throws Exception;
}
