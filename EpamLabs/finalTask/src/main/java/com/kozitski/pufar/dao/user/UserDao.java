package com.kozitski.pufar.dao.user;

import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;

import java.util.ArrayList;
import java.util.Optional;

public interface UserDao {

    Optional<User> searchUserById(long id);
    Optional<User> searchUserByLogin(String login);

    ArrayList<User> searchUsersByStatus(UserStatus status);

}
