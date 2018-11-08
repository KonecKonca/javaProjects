package com.kozitski.pufar.controller.autorization;

import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.entity.user.UserStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("view/login/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User(12, login, password, UserStatus.ADMIN);

        HttpSession session = request.getSession();
        if(user != null){
            session.setAttribute("user", user);
            response.sendRedirect("view/profile.jsp");
            return;
        }

        // if will troubles
        response.sendRedirect("login.jsp?loginorpassword=invalid");  // any.jsp?loginorpassword=invalid

    }
}
