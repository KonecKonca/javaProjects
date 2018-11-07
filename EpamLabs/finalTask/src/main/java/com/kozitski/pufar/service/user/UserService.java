package com.kozitski.pufar.service.user;

import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> searchUserById(long id);
    Optional<User> searchUserByLogin(String login);

    List<User> searchUsersByStatus(UserStatus status);


}
