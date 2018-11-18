package com.kozitski.xml.controller;

import com.kozitski.xml.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.kozitski.xml.command.CommandType.CHOOSE_PARSER_COMMAND;

@WebServlet("/choose")
public class StartPageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Command command = CHOOSE_PARSER_COMMAND.getCommand();

        Router router = command.execute(request);

        if(router.isForward()){
            request.getRequestDispatcher(router.getPagePath()).forward(request, response);
        }

    }

}
