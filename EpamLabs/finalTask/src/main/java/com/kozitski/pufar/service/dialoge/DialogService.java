package com.kozitski.pufar.service.dialoge;

import com.kozitski.pufar.entity.message.UserMessage;

import java.util.List;

public interface DialogService {

    List<UserMessage> searchAllMessagesFromTo(long fromUserId, long toUserId);
    List<UserMessage> searchAllMessagesBetween(long userId1, long userId2);
    List<UserMessage> searchAllMessagesBetweenWithLimit(long userId1, long userId2, int since, int howMuch);

}
