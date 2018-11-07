package com.kozitski.pufar.util.mapper.user;

import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserMapper {

    public static User createUser(ResultSet resultSet) throws SQLException {

        long userId = resultSet.getLong("user_id");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        UserStatus status = defineUserStatus(resultSet.getString("value"));

        return new User(userId, login, password, status);

    }
    public static ArrayList<User> createUsers(ResultSet resultSet) throws SQLException {
        ArrayList<User> result = new ArrayList<>();

        while (resultSet.next()){
            long userId = resultSet.getLong("user_id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            UserStatus status = defineUserStatus(resultSet.getString("value"));

            result.add(new User(userId, login, password, status));
        }

        return result;

    }

    private static UserStatus defineUserStatus(String status){

        switch (status.toUpperCase()){

            case ConstantUserStatus.SIMPLE_USER:
                return UserStatus.SIMPLE_USER;

            case ConstantUserStatus.ADMIN:
                return UserStatus.ADMIN;

            case ConstantUserStatus.SUPER_ADMIN:
                return UserStatus.SUPER_ADMIN;

            default:
                return UserStatus.SIMPLE_USER;
        }

    }

}
