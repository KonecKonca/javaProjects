package model.repository;

import model.db.DBHelper;
import model.entity.AppEntity;
import model.entity.User;
import model.specification.SQLSpecification;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UserRepository  implements Repository<User>{


    @Override
    public void add(User user) {
        Statement stm= null;
        PreparedStatement ps=null;

        String query="INSERT INTO user (login, password, name, surname) VALUES(?,?,?,?)";

        try {
            //stm = db.getDBConnection().createStatement();
            ps=DBHelper.getInstance().getDBConnection().prepareStatement(query);
            ps.setString(1, user.getLogin());
            ps.setString(2,user.getPassword());
                    ps.setString(3, user.getName());
                            ps.setString(4,  user.getSurname());
                            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

    }

    @Override
    public void remove(User user) {
       // db.executeQuery("DELETE FROM user WHERE user.id="+ user.getId()+";");
    }

    @Override
    public void update(User user) {
        //db.executeQuery("UPDATE user SET "
    }

    @Override
    public List<User> query(SQLSpecification specification)  {
        Statement stm= null;

        String query=specification.toSqlClauses();

        List<User> users = new ArrayList<>();

        try {
            stm = db.getDBConnection().createStatement();
            ResultSet rs=stm.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData ();
            int cols = rsmd.getColumnCount ();
            while (rs.next ()) {
                List<Object> newRow = new ArrayList<>();
                for (int i = 1; i <= cols; i++) {
                    newRow.add (rs.getObject (i));
                }

                User user=new User();
                user.setId((Integer) newRow.get(0));
                user.setLogin((String) newRow.get(1));
                user.setPassword((String)newRow.get(2));
                user.setName((String)newRow.get(3));
                user.setSurname((String)newRow.get(4));
                users.add(user);

            }
            rs.close ();
            stm.close ();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

        return users;
    }
}
