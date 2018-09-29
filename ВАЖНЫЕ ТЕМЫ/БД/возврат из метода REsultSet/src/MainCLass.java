import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
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
    private static String userName = "root";
    private static String password = "123ghu475R7px6";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/alan?serverTimezone=UTC&useSSL=false";

    public static void main(String[] args) throws Exception{
        ResultSet resultSet = getData();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("branch_id") + "\t" + resultSet.getString("name")
                    + "\t" + resultSet.getString("address"));
        }

        CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
        cachedRowSet.setUrl(connectionUrl);
        cachedRowSet.setUsername(userName);
        cachedRowSet.setPassword(password);

//        cachedRowSet.setCommand("SELECT name FROM branch WHERE id IN (?, ?, ?)");
//        cachedRowSet.setInt(1,1);
//        cachedRowSet.setInt(2,2);
//        cachedRowSet.setInt(3,5);
//        cachedRowSet.execute();
//
//        while (cachedRowSet.next()){
//            System.out.println(cachedRowSet.getString("name"));
//        }

    }

    private static ResultSet getData()throws Exception{
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){  // 1-ое: возможно скролить  2-ое : возможность изменять

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM branch");
            cachedRowSet.populate(resultSet);  // по сути закидываем в новый резсет старые данные
            return cachedRowSet;  // т.к при выходи из базы коннектион с БД закрывается, есть такая фича как CachedRowSet
        }
    }
}