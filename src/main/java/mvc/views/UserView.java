package mvc.views;

import mvc.controllers.EventController;
import mvc.controllers.UserController;
import mvc.controllers.interfaces.IEventController;
import mvc.controllers.interfaces.IUserController;
import mvc.models.UserTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alisa on 5/14/2017.
 */
public class UserView extends AbstractEntityView{

    private IUserController userController;
    private UserTableModel userTableModel;
    private JTable usersTable;
    private JFrame parent;

    public UserView(UserController userController, EventController eventController, JFrame parent) throws Exception {
        super(eventController);
        this.userController = userController;
        this.parent = parent;
        this.userTableModel = new UserTableModel(this.userController.getAll());
    }

    public JPanel createUsersTable() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        try {
            usersTable = new JTable(userTableModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane pane = new JScrollPane(usersTable);
        panel.add(pane);
        panel.setBorder(BorderFactory.createTitledBorder("Participants"));
        return panel;
    }

    @Override
    public void refreshView() throws Exception {
        userTableModel.setUsers(userController.getAll());
        usersTable.repaint();
    }
}
