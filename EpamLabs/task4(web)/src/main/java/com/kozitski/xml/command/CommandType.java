package com.kozitski.xml.command;

import com.kozitski.xml.logic.ParserReceiver;

public enum CommandType {
    CHOOSE_PARSER_COMMAND(new ChooseParserCommand(new ParserReceiver())),
    CHOOSE_XML_COMMAND(new ChooseXmlCommand()),
    INPUT_XML_COMMAND(new InputXmlCommand());

    private Command command;

    CommandType(Command command){
        this.command = command;
    }
    public Command getCommand() {
        return command;
    }

}
