package com.kozitski.xml.controller;

import com.kozitski.xml.command.Command;
import com.kozitski.xml.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/choose")
public class StartPageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Command command = CommandFactory.chooseCommand(request.getParameter(CommandNameConstant.CHOOSE_PARSER_COMMAND));

        Router router = command.execute(request);

        if(router.isForward()){
            request.getRequestDispatcher(router.getPagePath()).forward(request, response);
        }
        else {
            response.sendRedirect(router.getPagePath());
        }

    }

}
