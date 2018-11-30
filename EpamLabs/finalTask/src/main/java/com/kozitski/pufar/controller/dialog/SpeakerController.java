package com.kozitski.pufar.controller.dialog;

import com.kozitski.pufar.command.AbstractCommand;
import com.kozitski.pufar.command.CommandFactory;
import com.kozitski.pufar.command.RequestValue;
import com.kozitski.pufar.command.Router;
import com.kozitski.pufar.util.request.RequestValueTransformer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/speaker")
public class SpeakerController extends HttpServlet {

    public static final String COMMAND_NAME = "showOpponents";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AbstractCommand command = CommandFactory.chooseCommand(request.getParameter(COMMAND_NAME));

        RequestValue requestValue = RequestValueTransformer.transformFrom(request);
        Router router = command.execute(requestValue);
        RequestValueTransformer.transformTo(request, requestValue);

        if(router.isForward()){
            request.getRequestDispatcher(router.getPagePath()).forward(request, response);
        }
        else {
            response.sendRedirect(router.getPagePath());
        }

    }


}
