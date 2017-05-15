package mvc.views;

import mvc.controllers.EventController;
import mvc.controllers.UserController;
import mvc.controllers.interfaces.IEventController;
import mvc.controllers.interfaces.IUserController;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alisa on 5/14/2017.
 */
public class MainView extends JFrame{

    private UserView userView;
    private EventView eventView;

    public MainView(UserController userController, EventController eventController) throws Exception {
        this.userView = new UserView(userController, eventController, MainView.this);
        this.eventView = new EventView(eventController, MainView.this);
        initialize();
    }

    private void initialize(){
        setLayout(new GridLayout(2,2));
        add(eventView.createEventsTable());
        add(userView.createUsersTable());
        add(eventView.createChangeDescriptionPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
