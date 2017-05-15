package mvc.controllers;

import domain.User;
import mvc.controllers.interfaces.IUserController;
import mvc.models.UserModel;
import mvc.models.UserTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.interfaces.IEventRepository;
import repositories.interfaces.IUserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alisa on 5/14/2017.
 */
public class UserController implements IUserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IEventRepository eventRepository;

    private UserTableModel userTableModel;

    @Override
    public void save(UserModel userModel) throws Exception {
        try {
            User user = new User(userModel.getId(), userModel.getName());
            userRepository.save(user);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public List<UserModel> getAll() throws Exception {
        try {
            List<User> dbUsers = userRepository.getAll();
            List<UserModel> userModels = dbUsers
                    .stream()
                    .map(e -> new UserModel(e.getId(), e.getName(), eventRepository.findOne(e.getEventId()).getDescription()))
                    .collect(Collectors.toList());
            return userModels;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public UserModel findOne(Integer id) throws Exception {
        try {
            User user = userRepository.findOne(id);
            UserModel userModel = new UserModel(user.getId(), user.getName(), eventRepository.findOne(user.getEventId()).getDescription());
            return userModel;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public UserTableModel getUserTableModel() throws Exception {
        userTableModel = new UserTableModel(getAll());
        return userTableModel;
    }

    @Override
    public void refreshUserTableModel() throws Exception {
        userTableModel.setUsers(getAll());
    }

    public IUserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
