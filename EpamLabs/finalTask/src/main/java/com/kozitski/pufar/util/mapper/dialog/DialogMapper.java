package com.kozitski.pufar.util.mapper.dialog;

import com.kozitski.pufar.entity.message.UserMessage;
import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DialogMapper {

    public static ArrayList<UserMessage> createMessages(ResultSet resultSet) throws SQLException {
        ArrayList<UserMessage> result = new ArrayList<>();

        while (resultSet.next()){

            String sender_login = resultSet.getString("sender_login");
            String receiver_login = resultSet.getString("receiver_login");
            String message = resultSet.getString("message");
            Date date = resultSet.getDate("date");

            result.add(new UserMessage(message, date, sender_login, receiver_login));
        }

        return result;
    }

}
