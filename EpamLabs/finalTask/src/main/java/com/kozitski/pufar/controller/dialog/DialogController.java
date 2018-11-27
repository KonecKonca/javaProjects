package com.kozitski.pufar.controller.dialog;

import com.kozitski.pufar.entity.message.UserMessage;
import com.kozitski.pufar.service.dialoge.DialogService;
import com.kozitski.pufar.service.dialoge.DialogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dialog")
public class DialogController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DialogService dialogService = new DialogServiceImpl();


        List<UserMessage> messages = dialogService.searchAllMessagesBetweenWithLimit(1, 2, 1, 3);

        for(UserMessage userMessage : messages){
            resp.getWriter().write("\t  " + userMessage.getTime() +  ":: " + userMessage.getSenderLogin() + " to "
                    + userMessage.getReceiverLogin() + " message: " + userMessage.getMessage() + "\n");
        }

    }
}
