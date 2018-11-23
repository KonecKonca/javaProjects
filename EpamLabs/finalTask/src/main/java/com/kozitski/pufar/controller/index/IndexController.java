package com.kozitski.pufar.controller.index;

import com.kozitski.pufar.validation.TestSample;
import com.kozitski.pufar.validation.aspect.ValidationAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.sendRedirect("/view/index/index.jsp");


        /// MUST BE DELETED ONLY FOR TESTING
        TestSample.fasad();

    }

}

