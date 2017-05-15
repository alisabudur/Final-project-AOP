package mvc.models;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public class UserTableModel extends AbstractTableModel {

    private List<UserModel> users;
    private List<String> columns;

    public UserTableModel(List<UserModel> users) {
        this.users = users;
        this.columns = new ArrayList<>();

        this.columns.add("Id");
        this.columns.add("Name");
        this.columns.add("Event description");
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column);
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return users.get(rowIndex).getId();
            case 1: return users.get(rowIndex).getName();
            case 2: return users.get(rowIndex).getEventDescription();
        }
        return null;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
