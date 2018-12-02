package com.kozitski.pufar.service.autorization;


import com.kozitski.pufar.dao.user.MySQLUserDao;
import com.kozitski.pufar.dao.user.UserDao;
import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;
import com.kozitski.pufar.util.encoder.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {
    private static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    private UserDao userDao = new MySQLUserDao();

    @Override
    public Optional<User> searchUserByLoginPassword(String login, String password){
        Optional<User> result = Optional.empty();

        Optional<User> user = userDao.searchUserByLogin(login);
        if(user.isPresent()){
            User currentUser = user.get();

            if(PasswordEncoder.comparePasswordsWithoutEncoding(PasswordEncoder.encode(password), currentUser.getPassword())){
                result = Optional.of(currentUser);
            }
        }

        return result;
    }

}
