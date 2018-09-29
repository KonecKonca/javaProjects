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

            // Создание процедуры
            CallableStatement callableStatement = connection.prepareCall("{call getCount()}");
            boolean hasResult = callableStatement.execute(); // проверка на пустоту
            while (hasResult){
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()){
                    System.out.println("Столько строк в табличке" + resultSet.getInt(1));
                }
                hasResult = callableStatement.getMoreResults();
            }
        }
    }
}