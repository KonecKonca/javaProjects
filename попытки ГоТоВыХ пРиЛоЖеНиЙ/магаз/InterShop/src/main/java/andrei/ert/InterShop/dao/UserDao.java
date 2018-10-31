package andrei.ert.InterShop.dao;

import andrei.ert.InterShop.entity.User;

import java.util.List;

public interface UserDao {

    void delete(int id);
    void save(User user);
    void update (User user);
    User getById(int id);
    List<User> findAll();

}
