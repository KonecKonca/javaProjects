package com.kozitski.pufar.command.impl;

import com.kozitski.pufar.command.AbstractCommand;
import com.kozitski.pufar.command.PagePath;
import com.kozitski.pufar.command.RequestValue;
import com.kozitski.pufar.command.Router;
import com.kozitski.pufar.entity.message.UserMessage;
import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.service.dialoge.DialogService;
import com.kozitski.pufar.service.dialoge.DialogServiceImpl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetContactCommand extends AbstractCommand {
    private static final int HOW_MUCH_USERS = 7;
    private static final int HOW_MUCH_MESSAGES = 20;

    // since what message (for checking message history)
//    public static final int

    private DialogService dialogService = new DialogServiceImpl();

    @Override
    public Router execute(RequestValue requestValue) {
        Router router = new Router();

        int currentUserId = Integer.parseInt(requestValue.getAttribute("userId").toString());
        List<User> users = dialogService.searchPopularUser(currentUserId, HOW_MUCH_USERS);

        List<UserMessage> lastMessagesWithTopUser = null;
        if(users.size() > 0){
            lastMessagesWithTopUser = dialogService.searchMessagesBetweenWithLimit(currentUserId, users.get(0).getUserId(), 0, HOW_MUCH_MESSAGES);
        }

        requestValue.requestAttributePut("topUsers", users);
        requestValue.requestAttributePut("lastMessages",lastMessagesWithTopUser);
        router.setPagePath(PagePath.CHAT_PAGE.getJspPath());

        return router;
    }


}
