package com.kozitski.pufar.entity.message;

import com.kozitski.pufar.validation.annotation.AspectValid;
import com.kozitski.pufar.validation.annotation.StringValid;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class UserMessage {
    private String message;
    private Date date;
    private Time time;
    private String senderLogin;
    private String receiverLogin;

    public UserMessage() {
    }

    public UserMessage(String message, Date date, Time time, String senderLogin, String receiverLogin) {
        this.message = message;
        this.date = date;
        this.time = time;
        this.senderLogin = senderLogin;
        this.receiverLogin = receiverLogin;
    }

    public String getMessage() {
        return message;
    }
    public Date getDate() {
        return date;
    }
    public String getSenderLogin() {
        return senderLogin;
    }
    public String getReceiverLogin() {
        return receiverLogin;
    }
    public Time getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserMessage)) return false;
        UserMessage that = (UserMessage) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(date, that.date) &&
                Objects.equals(senderLogin, that.senderLogin) &&
                Objects.equals(receiverLogin, that.receiverLogin);
    }
    @Override
    public int hashCode() {
        return Objects.hash(message, date, senderLogin, receiverLogin);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Message: from (");
        stringBuilder.append(senderLogin);
        stringBuilder.append("), to");
        stringBuilder.append("(");
        stringBuilder.append(receiverLogin);
        stringBuilder.append("), content: ");
        stringBuilder.append(message);
        stringBuilder.append(", date: ");
        stringBuilder.append(date);

        return stringBuilder.toString();
    }
}
