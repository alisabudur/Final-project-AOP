package repositories.interfaces;

import domain.User;

import java.util.List;

/**
 * Created by Alisa on 5/14/2017.
 */
public interface IUserRepository {
    List<User> getAll();
    void save(User event);
    User findOne(Integer id);
}
