package model.db;

import com.sun.corba.se.spi.orbutil.fsm.Guard;

import java.sql.*;

public class DBHelper {
    private static DBHelper helper=new DBHelper();
   // private  static final String driver;
    private static final String url="jdbc:mysql://localhost:3306/diplomaDB";
    private static final String login="root";
    private static final String password="root";
    private static Connection connection;

    private DBHelper(){
    }

    public static DBHelper getInstance(){
        return helper;
    }

  public  Connection getDBConnection(){
      try {
          connection=DriverManager.getConnection(url,login,password);
      } catch (SQLException e) {
          e.printStackTrace();
      }
       return connection;
    }

   /* public void createDBConnection(){
        try {
            connection=DriverManager.getConnection(url,login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


   /* public ResultSet executeQuery(String query){
        ResultSet r=null;
        Statement stm=null;
        try {
            stm=connection.createStatement();
            PreparedStatement s = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }*/

    public void closeDBConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
