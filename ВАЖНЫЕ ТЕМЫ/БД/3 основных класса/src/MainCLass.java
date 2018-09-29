import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 3 основных класса для работы с БД
//  Connection -- дял подключени
//  Statement -- для создания и внесения данных
//  ResultSet -- для получения данных

public class MainCLass{
    public static void main(String[] args) throws Exception{
        String userName = "root";
        String password = "123ghu475R7px6";                                          //  servertimezon (неведомая хуяня, котрую нужно отключить)
        String connectionUrl = "jdbc:mysql://localhost:3306/alan?serverTimezone=UTC&useSSL=false";  // ?useSSL=false (чтоб не было предупреждения)
        //Class.forName("com.mysql.jdbc.Driver");  // сюда имя используемого драйвера  (этот онли для mysql)
        // типо уже можно не писать
        // раньше был трабл с жаркой(я закидывал не в 8-ую jdk, а не в 10-ку на которой создан проект)
        // + кидаю драйвер жарку в систеамную джававскую папку

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()){  //  есть executeQuery(селекты)  и executeupdates(измен структцры)
            ResultSet resultSet = statement.executeQuery("SELECT * FROM XYI");

            while (resultSet.next()){
                System.out.print(resultSet.getInt("id") + "\t");
                System.out.println(resultSet.getString("name"));
                System.out.println("------------------------");
            }
        }
    }
}
