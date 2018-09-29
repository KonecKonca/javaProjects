import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

//      Read_commited -- будет ждать конца транзакций которые уже юзают данные  (решает dirty read)
//      REpiatable_Read  -- также ждёт конца всех транзакций и берёт данные до коммита(даже если он был)
                            // типо селект до изменения будет такой же как и селект после изменения
                            // изменяющая транзакция ждёт пока отработает др транзакция
//      Read_Serialable   фантомное чтение, только в отличии от REpiatable_Read данные не апдейтятся а инсёртятся

public class MainCLass{
    private static String userName = "root";
    private static String password = "123ghu475R7px6";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/alan?serverTimezone=UTC&useSSL=false";

    public static void main(String[] args) throws Exception{

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()){

            connection.setAutoCommit(false);
            statement.executeUpdate("UPDATE branch SET name = 'XYI' WHERE branch_id = 11");

            new OtherTransaction().start();
            Thread.sleep(100);

            connection.rollback();
        }
    }

    static class OtherTransaction extends Thread{
        @Override
        public void run() {
            try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
                Statement statement = connection.createStatement()){

                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);  // по умолчания считывается только закоммиченное
                // а так всё считывается по факту

                ResultSet resultSet = statement.executeQuery("SELECT * FROM  branch WHERE branch_id = 11");

                while (resultSet.next()){
                    System.out.println(resultSet.getString("name"));  // тут выводится значения которое уже ролбэкнулось
                }
            }
            catch (Exception ex){

            }
        }
    }
}
