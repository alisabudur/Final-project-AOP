import mvc.controllers.EventController;
import mvc.controllers.UserController;
import mvc.controllers.interfaces.IEventController;
import mvc.controllers.interfaces.IUserController;
import mvc.views.MainView;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.swing.*;

/**
 * Created by Alisa on 5/14/2017.
 */
public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        final ApplicationContext factory = new FileSystemXmlApplicationContext("D:\\Facultate\\Semestrul 6\\Aop\\FinalProject\\src\\main\\resources\\SpringConfig.xml");

        UserController userController = factory.getBean(UserController.class);
        EventController eventController = factory.getBean(EventController.class);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainView mainView = null;
                try {
                    mainView = new MainView(userController, eventController);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mainView.setSize(700, 500);
                mainView.setLocation(150, 150);
                mainView.setVisible(true);
            }
        });
    }
}
