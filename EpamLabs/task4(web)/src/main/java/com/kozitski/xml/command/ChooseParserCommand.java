package com.kozitski.xml.command;

import com.kozitski.xml.controller.Router;
import com.kozitski.xml.logic.ParserReceiver;

import javax.servlet.http.HttpServletRequest;

import static com.kozitski.xml.command.JSPPathConstant.INDEX_JSP;
import static com.kozitski.xml.command.JSPPathConstant.LOAD_FILE_JSP;

public class ChooseParserCommand implements Command{
    public static final String PARAM_PARSER = "parser";
    private ParserReceiver receiver;

    public ChooseParserCommand(ParserReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String page = INDEX_JSP;

        String parserType = request.getParameter(PARAM_PARSER);

        if(parserType != null && !parserType.isEmpty()){
            if(receiver.isParser(parserType)){
                request.setAttribute(PARAM_PARSER, parserType);

                page = LOAD_FILE_JSP;
            }
        }

        router.setPagePath(page);
        return router;
    }

}
