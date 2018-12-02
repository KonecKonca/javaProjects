package com.kozitski.pufar.dao.user;

import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;
import com.kozitski.pufar.exception.PufarDAOException;
import com.kozitski.pufar.validation.annotation.AspectValid;
import com.kozitski.pufar.validation.annotation.primitive.integer.IntValid;
import com.kozitski.pufar.validation.annotation.primitive.string.StringValid;
import com.kozitski.pufar.validation.annotation.user.UserValid;

import java.util.ArrayList;
import java.util.Optional;

public interface UserDao {

    @AspectValid
    Optional<User> searchUserById(@IntValid long id);
    @AspectValid
    Optional<User> searchUserByLogin(@StringValid String login);
    ArrayList<User> searchUsersByStatus(UserStatus status);

    @AspectValid
    void addUser(@UserValid User user) throws PufarDAOException;

}
