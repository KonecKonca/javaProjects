package com.kozitski.pufar.controller.autorization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();

//        response.sendRedirect("view/common/infoPage.jsp");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/common/infoPage.jsp");
        dispatcher.forward(request, response);


    }


}
