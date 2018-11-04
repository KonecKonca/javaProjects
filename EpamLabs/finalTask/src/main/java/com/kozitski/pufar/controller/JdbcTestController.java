package com.kozitski.pufar.controller;

import com.kozitski.pufar.connection.PoolConnection;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/test")
public class JdbcTestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pufar?serverTimezone=UTC&useSSL=false",
//                "root", "123ghu475R7px6")){
//
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM statuses");
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()){
//                resp.getWriter().write(resultSet.getString("status_id") + "\t" + resultSet.getString("value"));
//            }
//
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }


        try {
            PoolConnection poolConnection = PoolConnection.getInstance("jdbc:mysql://localhost:3306/pufar?serverTimezone=UTC&useSSL=false",
                    "root", "123ghu475R7px6");
            Connection connection = poolConnection.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            while (resultSet.next()){
                resp.getWriter().write(resultSet.getString("user_id") + "\t" + resultSet.getString("login")
                        + resultSet.getString("password") + "\t" + resultSet.getString("status"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
