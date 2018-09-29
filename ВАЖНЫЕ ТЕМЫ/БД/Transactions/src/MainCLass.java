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

            // чтобы не терять скорость в новом соединении для каждого запроса
            // можно накатить группой сразу несколько запросов

            connection.setAutoCommit(false);   // между этим сама транзакция

            statement.executeUpdate("INSERT INTO branch VALUES(NULL, 'Andrei', 'xxx', 'xxx', 'xx', 'xxx')");
            statement.executeUpdate("INSERT INTO branch VALUES(NULL, 'Ne Andrei', 'xxx', 'xxx', 'xx', 'xxx')");
            Savepoint savepoint = connection.setSavepoint();  // точка сохранения полезно когда нужно отменить не всё
            statement.executeUpdate("INSERT INTO branch VALUES(NULL, 'Ne Andrei2', 'xxx', 'xxx', 'xx', 'xxx')");

            // rollback без параметра просто откатит к ласт коммиту
            connection.rollback(savepoint);    // вренутся к предидущ коммиту ( не относится к операциям изменения структуры)   // ДО КОММИТА
            connection.commit();            // между этим сама транзакция

            connection.releaseSavepoint(savepoint);  // это кстати хз зачем
        }
    }
}
