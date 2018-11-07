package com.kozitski.pufar.service.user;

import com.kozitski.pufar.dao.user.MySQLUserDao;
import com.kozitski.pufar.dao.user.UserDao;
import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new MySQLUserDao();

    public Optional<User> searchUserById(long id){

        // any validation
        return userDao.searchUserById(id);
    }


    @Override
    public Optional<User> searchUserByLogin(String login) {

        // any validation
        return userDao.searchUserByLogin(login);
    }

    @Override
    public ArrayList<User> searchUsersByStatus(UserStatus status) {

        // any validation
        return userDao.searchUsersByStatus(status);
    }


}
