import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainCLass{
    public static void main(String[] args) throws Exception{
        String userName = "root";
        String password = "123ghu475R7px6";
        String connectionUrl = "jdbc:mysql://localhost:3306/alan?serverTimezone=UTC&useSSL=false";

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()){

            statement.addBatch("INSERT INTO branch VALUES(NULL, 'Andrei', 'yyy', 'yyy', 'yy', 'yyy')");
            statement.addBatch("INSERT INTO branch VALUES(NULL, 'Ne Andrei', 'xxx', 'xxx', 'xx', 'xxx')");

            System.out.println(statement.executeBatch().length);  // массив запросов
            // длинна 2

        }
    }
}
