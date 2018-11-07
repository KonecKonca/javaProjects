package com.kozitski.pufar.dao.user;

import com.kozitski.pufar.connection.PoolConnection;
import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;
import com.kozitski.pufar.exception.PufarDAOException;
import com.kozitski.pufar.util.mapper.user.UserMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLUserDao implements UserDao {

    //  need in debug
    @Override
    public Optional<User> searchUserById(long id) {
        String sql = "SELECT u.user_id, u.login, u.password, s.value FROM users u LEFT JOIN statuses s ON u.status = s.status_id WHERE user_id = ?";

        try(Connection  connection = PoolConnection.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = UserMapper.createUser(resultSet);

            return Optional.of(user);
        }

        catch (PufarDAOException | SQLException e) {
            return Optional.empty();
        }

    }
    @Override
    public Optional<User> searchUserByLogin(String login) {
        String sql = "SELECT u.user_id, u.login, u.password, s.value FROM users u LEFT JOIN statuses s ON u.status = s.status_id WHERE u.login = ?";

        try(Connection  connection = PoolConnection.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = UserMapper.createUser(resultSet);

            return Optional.of(user);
        }

        catch (PufarDAOException | SQLException e) {
            return Optional.empty();
        }

    }
    @Override
    public ArrayList<User> searchUsersByStatus(UserStatus status) {
        String sql = "SELECT u.user_id, u.login, u.password, s.value FROM users u LEFT JOIN statuses s ON u.status = s.status_id WHERE s.value = ?";

        ArrayList<User> result;

        try(Connection  connection = PoolConnection.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status.name());
            ResultSet resultSet = preparedStatement.executeQuery();

            result = UserMapper.createUsers(resultSet);

        }

        catch (PufarDAOException | SQLException e) {
            return new ArrayList<User>();
        }

        return result;
    }

}
