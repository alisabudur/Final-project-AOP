package mvc.controllers.interfaces;

import mvc.models.UserModel;
import mvc.models.UserTableModel;

import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public interface IUserController {
    List<UserModel> getAll() throws Exception;
    void save(UserModel user) throws Exception;
    UserModel findOne(Integer id) throws Exception;
    UserTableModel getUserTableModel() throws Exception;
    void refreshUserTableModel() throws Exception;
}
