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

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"Table"});
            while (resultSet.next()){
                System.out.println(resultSet.getString(3)); // номера в соответствии с параметрами
            }

            System.out.println("\n\n");
            ResultSet resultSet2 = statement.executeQuery("SELECT  * FROM branch");
            ResultSetMetaData resultSetMetaData = resultSet2.getMetaData();
            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                System.out.println(resultSetMetaData.getColumnLabel(i));
            }
        }
    }
}
