package com.kozitski.pufar.command;

import com.kozitski.pufar.command.impl.GetContactCommand;
import com.kozitski.pufar.command.impl.IndexCommand;

public enum CommandType {

    INDEX(new IndexCommand()),
    GET_CONTACT(new GetContactCommand()),
    LOGIN(new IndexCommand()),
    LOGOUT(new IndexCommand()),
    SHOW_DIALOGS(new IndexCommand()),
    SHOW_DIALOG(new IndexCommand()),
    SHOW_NOTIFICATIONS(new IndexCommand()),
    SHOW_NOTIFICATION(new IndexCommand()),
    PROFILE(new IndexCommand()),
    SHOW_INFO_PAGE(new IndexCommand());

    private AbstractCommand command;

    CommandType(AbstractCommand command) {
        this.command = command;
    }
    public AbstractCommand getCommand() {
        return command;
    }

}
