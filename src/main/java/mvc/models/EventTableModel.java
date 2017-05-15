package mvc.models;

import domain.annotations.UpdateSubject;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public class EventTableModel extends AbstractTableModel{

    private List<EventModel> events;
    private List<String> columns;

    public EventTableModel(List<EventModel> events) {
        this.events = events;
        this.columns = new ArrayList<>();

        this.columns.add("Id");
        this.columns.add("Name");
        this.columns.add("Description");
        this.columns.add("No. participants");
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column);
    }

    @Override
    public int getRowCount() {
        return events.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return events.get(rowIndex).getId();
            case 1: return events.get(rowIndex).getName();
            case 2: return events.get(rowIndex).getDescription();
            case 3: return events.get(rowIndex).getParticipants();
        }
        return null;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    @UpdateSubject
    public void setEvents(List<EventModel> events) {
        this.events = events;
    }
}
