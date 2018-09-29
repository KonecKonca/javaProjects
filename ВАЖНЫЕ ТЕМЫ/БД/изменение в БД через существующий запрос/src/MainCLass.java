import javax.tools.DocumentationTool;
import javax.xml.stream.Location;
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
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){  // 1-ое: возможно скролить  2-ое : возможность изменять

            ResultSet resultSet = statement.executeQuery("SELECT * FROM branch");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name") + "\t" + resultSet.getString("city")
                                    + "\t\t" + resultSet.getString("address"));
            }
            System.out.println("\n\n");


            resultSet.last();
            resultSet.updateString("name", "new Value");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "inserted string");
            resultSet.insertRow();

//            resultSet.absolute(1);   // не канала так стои внешний ключ
//            resultSet.deleteRow();  // после делита не надо updateRow()

            while (resultSet.next()){
                System.out.println(resultSet.getString("name") + "\t" + resultSet.getString("city")
                        + "\t\t" + resultSet.getString("address"));
            }
         }
    }
}