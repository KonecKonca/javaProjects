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

            //ResultSet resultSet = statement.executeQuery("SELECT * FROM customer WHERE cust_type_cd = 'I' AND postal_code = 03079");
            // сюда инъекции можно воткнуть

            String code = "03079";  // сюда могут воткнуть инъекцию
            String type = "I"; // сюда могут воткнуть инъекцию


            // Сюда уже инъекцию нельзя воткнуть ( происходит автоматическая проверка )
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE cust_type_cd = ? AND postal_code = ?");
            preparedStatement.setString(1, type);  // нумерация с единички
            preparedStatement.setString(2, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.print(resultSet.getInt("cust_id") + "\t");
                System.out.print(resultSet.getString("address") + "\t");
                System.out.println(resultSet.getString("postal_code") + "\t");
                System.out.println("------------------------------");
            }
        }
    }
}
