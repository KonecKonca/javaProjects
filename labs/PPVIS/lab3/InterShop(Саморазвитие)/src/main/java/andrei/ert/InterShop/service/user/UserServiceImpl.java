package andrei.ert.InterShop.service.user;

import andrei.ert.InterShop.dao.user.UserDao;
import andrei.ert.InterShop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
    @Override
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    public void update(User user) {
        userDao.update(user);
    }
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
