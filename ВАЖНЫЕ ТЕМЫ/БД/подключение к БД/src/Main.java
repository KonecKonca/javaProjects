import com.sun.jndi.toolkit.url.Uri;

        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.net.*;
        import java.sql.Connection;
        import java.sql.Driver;
        import java.sql.DriverManager;
        import java.util.List;
        import java.util.Map;
        import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        String userName = "root";
        String password = "123ghu475R7px6";                                          //  типо отключить поверку подлиности сервера
        String connectionUrl = "jdbc:mysql://localhost:3306/test?useSSL=false";  // ?useSSL=false (чтоб не было предупреждения)
        Class.forName("com.mysql.jdbc.Driver");  // сюда имя используемого драйвера  (этот онли для mysql)

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password)){
            System.out.println("We are connected");
        }
    }
}