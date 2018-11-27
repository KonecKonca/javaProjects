package com.kozitski.pufar.dao.dialoge;

import com.kozitski.pufar.connection.PoolConnection;
import com.kozitski.pufar.entity.message.UserMessage;
import com.kozitski.pufar.exception.PufarDAOException;
import com.kozitski.pufar.util.mapper.dialog.DialogMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDialogDao implements DialogDAO {

    @Override
    public List<UserMessage> searchAllMessagesFromTo(long fromUserId, long toUserId) {

        String sql = "SELECT u1.login sender_login, u2.login receiver_login, message, date FROM dialoges d LEFT JOIN users u1 ON d.user_sender_id = u1.user_id " +
                "LEFT JOIN users u2 ON d.user_receiver_id = u2.user_id WHERE d.user_sender_id = ? AND d.user_receiver_id = ?";

        List<UserMessage> messages;

        try(Connection connection = PoolConnection.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, fromUserId);
            preparedStatement.setLong(2, toUserId);
            ResultSet resultSet = preparedStatement.executeQuery();

            messages = DialogMapper.createMessages(resultSet);

        }

        catch (PufarDAOException | SQLException e) {
            return new ArrayList<>();
        }

        return messages;
    }
    @Override
    public List<UserMessage> searchAllMessagesBetween(long userId1, long userId2) {
        String sql =    "SELECT u1.login sender_login, u2.login receiver_login, message, date FROM dialoges d " +
                            "LEFT JOIN users u1 ON d.user_sender_id = u1.user_id " +
                            "LEFT JOIN users u2 ON d.user_receiver_id = u2.user_id WHERE d.user_sender_id = ? AND d.user_receiver_id = ? " +

                        "UNION " +

                        "SELECT u3.login sender_login, u4.login receiver_login, message, date FROM dialoges d " +
                            "LEFT JOIN users u3 ON d.user_sender_id = u3.user_id " +
                            "LEFT JOIN users u4 ON d.user_receiver_id = u4.user_id WHERE d.user_sender_id = ? AND d.user_receiver_id = ? " +

                        "ORDER BY date ASC";


        List<UserMessage> messages;

        try(Connection connection = PoolConnection.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId1);
            preparedStatement.setLong(2, userId2);
            preparedStatement.setLong(3, userId2);
            preparedStatement.setLong(4, userId1);
            ResultSet resultSet = preparedStatement.executeQuery();

            messages = DialogMapper.createMessages(resultSet);

        }

        catch (PufarDAOException | SQLException e) {
            return new ArrayList<>();
        }

        return messages;
    }
    @Override
    public List<UserMessage> searchAllMessagesBetweenWithLimit(long userId1, long userId2, int since, int howMuch) {
        String sql =    "SELECT u1.login sender_login, u2.login receiver_login, message, date FROM dialoges d " +
                            "LEFT JOIN users u1 ON d.user_sender_id = u1.user_id " +
                            "LEFT JOIN users u2 ON d.user_receiver_id = u2.user_id WHERE d.user_sender_id = ? AND d.user_receiver_id = ? " +

                        "UNION " +

                        "SELECT u3.login sender_login, u4.login receiver_login, message, date FROM dialoges d " +
                            "LEFT JOIN users u3 ON d.user_sender_id = u3.user_id " +
                            "LEFT JOIN users u4 ON d.user_receiver_id = u4.user_id WHERE d.user_sender_id = ? AND d.user_receiver_id = ? " +

                        "ORDER BY date ASC " +
                            "LIMIT ?, ?";


        List<UserMessage> messages;

        try(Connection connection = PoolConnection.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId1);
            preparedStatement.setLong(2, userId2);
            preparedStatement.setLong(3, userId2);
            preparedStatement.setLong(4, userId1);
            preparedStatement.setInt(5, since);
            preparedStatement.setInt(6, howMuch);
            ResultSet resultSet = preparedStatement.executeQuery();

            messages = DialogMapper.createMessages(resultSet);

        }

        catch (PufarDAOException | SQLException e) {
            return new ArrayList<>();
        }

        return messages;
    }

}
