package model.repository;

import model.db.DBHelper;
import model.entity.AppEntity;
import model.entity.Indicator;
import model.entity.Process;
import model.entity.User;
import model.specification.SQLSpecification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndicatorRepository implements Repository<Indicator>  {

    @Override
    public void add(Indicator indicator) {
        Statement stm= null;
        PreparedStatement ps=null;

        String query="INSERT INTO indicator (name, type,value, lowerLimit, upperLimit, plan, owner) VALUES(?,?,?,?,?,?,?)";

        try {
            //stm = db.getDBConnection().createStatement();
            ps=DBHelper.getInstance().getDBConnection().prepareStatement(query);
            ps.setString(1, indicator.getName());
            ps.setString(2, indicator.getType());
            ps.setDouble(3, indicator.getValue());
            ps.setDouble(4, indicator.getLowerLimit());
            ps.setDouble(5, indicator.getUpperLimit());
            ps.setDouble(6, indicator.getPlan());
            ps.setObject(7,indicator.getOwner());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();
    }

    @Override
    public void remove(Indicator indicator) {
        PreparedStatement ps=null;
        String query="DELETE FROM indicator WHERE id=";
        try {
            ps=DBHelper.getInstance().getDBConnection().prepareStatement(query);
            ps.setInt(1,indicator.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

    }

    @Override
    public void update(Indicator indicator) {
        PreparedStatement ps=null;

        String query="UPDATE indicator SET " +
                "name=?, type=?, value=?, lowerLimit=?, upperLimit=?, plan=?, owner=?"+
                " WHERE id=?";

        try {
            ps=DBHelper.getInstance().getDBConnection().prepareStatement(query);
            ps.setString(1,indicator.getName());
            ps.setString(2,indicator.getType());
            ps.setObject(3, indicator.getValue());
            ps.setDouble(4,indicator.getValue());
            ps.setDouble(5,indicator.getLowerLimit());
            ps.setDouble(6,indicator.getUpperLimit());
            ps.setDouble(7,indicator.getPlan());
            ps.setObject(8,indicator.getOwner());
            ps.setInt(9,indicator.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

    }

    @Override
    public List<Indicator> query(SQLSpecification specification) {
        Statement stm= null;

        String query=specification.toSqlClauses();

        List<Indicator> indicators = new ArrayList<>();

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

                Indicator i=new Indicator();
                i.setId((Integer) newRow.get(0));
                i.setName((String) newRow.get(1));
                i.setType((String)newRow.get(2));
                i.setValue((Double) newRow.get(3));
                i.setLowerLimit((Double)newRow.get(4));
                i.setUpperLimit((Double)newRow.get(5));
                i.setPlan((Double)newRow.get(6));
                i.setOwner((Process)newRow.get(7));
                indicators.add(i);

            }
            rs.close ();
            stm.close ();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

        return indicators;
    }
}
