package com.kozitski.pufar.controller.user;

import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.service.user.UserService;
import com.kozitski.pufar.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

//        if(userService.searchUserById(1).isPresent()){

            // add filter in future
            User user = userService.searchUserByLogin("andrei").get();  // must get id from session (onlu for autorised users)
            req.setAttribute("user", user);

            // must be redirect on jsp
            resp.getWriter().write(user.toString());
//        }

//        resp.sendRedirect("/view/profile.jsp");
    }

}
