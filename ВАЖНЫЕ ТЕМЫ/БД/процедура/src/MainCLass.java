import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
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

            // процедура в параметрах у которой онли возращ значение
            CallableStatement callableStatement = connection.prepareCall("{call getCountEmployee(?)}");   // call -- клбчевое слово
            callableStatement.registerOutParameter(1, Types.INTEGER);  // установл типо возвращ параметра
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));

            // с привычным нам параметром
            CallableStatement callableStatement2 = connection.prepareCall("{call getFromEmployee(13)}");
            //callableStatement2.setInt(1,13);  // в предыдущей строке можно вместо 13 пставить ?
            if(callableStatement2.execute()){
                ResultSet resultSet = callableStatement2.getResultSet();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("emp_id"));
                    System.out.println(resultSet.getString("fname"));
                    System.out.println(resultSet.getString("lname"));
                }
            }
         }
    }
}