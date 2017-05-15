package mvc.views;

import mvc.controllers.EventController;
import mvc.controllers.interfaces.IEventController;
import mvc.models.EventModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alisa on 5/14/2017.
 */
public class EventView extends AbstractEntityView{

    private IEventController eventController;
    private JTable eventsTable;
    private JTextField eventId;
    private JTextField eventDescription;
    private JButton changeDescription;
    private JFrame parent;

    public EventView(EventController eventController, JFrame parent) {
        super(eventController);
        this.eventController = eventController;
        this.parent = parent;
    }

    public JPanel createEventsTable() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        try {
            eventsTable = new JTable(eventController.getEventTableModel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane pane = new JScrollPane(eventsTable);
        eventsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventsTable.getSelectionModel().addListSelectionListener(new EventListSelectionListener());
        panel.add(pane);
        panel.setBorder(BorderFactory.createTitledBorder("Events"));
        return panel;
    }

    public JPanel createChangeDescriptionPanel() {
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(3, 1));
        JPanel linia1 = Utils.putInPanel(new JLabel("Id:"));
        linia1.add(eventId = new JTextField(7));
        eventId.setEditable(false);
        pan.add(linia1);

        JPanel linia2 = Utils.putInPanel(new JLabel("Description:"));
        linia2.add(eventDescription = new JTextField(7));
        pan.add(linia2);

        JPanel linia3 = Utils.putInPanel(changeDescription = new JButton("Change"));
        changeDescription.addActionListener(new ChangeButtonListener());
        pan.add(linia3);
        pan.setBorder(BorderFactory.createTitledBorder("Change event description"));
        return pan;
    }

    @Override
    public void refreshView() throws Exception {
        eventsTable.repaint();
    }

    private class EventListSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int index = eventsTable.getSelectedRow();
                if (index >= 0) {
                    String idSel = null;
                    try {
                        idSel = eventController.getSelectedEvent(index);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    eventId.setText(idSel);
                }

            }
        }
    }

    private class ChangeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String idString = eventId.getText();
            String description = eventDescription.getText();
            if (eventsTable.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(parent, "You must select an event", "Error changing description", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                Integer id = Integer.parseInt(idString);
                eventController.update(id, description);
                eventDescription.setText("");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, ex.getMessage(), "Eroare adaugare rezultat", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex);
                return;
            }
        }
    }
}
