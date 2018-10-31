package model.repository;

import model.db.DBHelper;
import model.entity.Process;
import model.entity.User;
import model.specification.SQLSpecification;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProcessRepository implements Repository<Process> {

    @Override
    public void add(Process process) {
        PreparedStatement ps=null;

        String query="INSERT INTO process " +
                "(name, type, duration, period, phase, status, objective, owner, subtype) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            ps=DBHelper.getInstance().getDBConnection().prepareStatement(query);
            ps.setString(1,process.getName());
            ps.setString(2,process.getType());
            ps.setObject(3, process.getDuration());
            ps.setInt(4,process.getPeriod());
            ps.setString(5,process.getPhase());
            ps.setString(6,process.getStatus());
            ps.setString(7,process.getObjective());
            ps.setInt(8,process.getOwner().getId());
            ps.setString(9,process.getSubType());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

    }

    @Override
    public void remove(Process process) {
        PreparedStatement ps=null;
        String query="DELETE FROM process WHERE id=";
        try {
            ps=DBHelper.getInstance().getDBConnection().prepareStatement(query);
            ps.setInt(1,process.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

    }

    @Override
    public void update(Process process) {
        PreparedStatement ps=null;

        String query="UPDATE process SET " +
                "name=?, type=?, duration=?, period=?, phase=?, status=?, objective=?, owner=?, subtype=?"+
                " WHERE id=?";

        try {
            ps=DBHelper.getInstance().getDBConnection().prepareStatement(query);
            ps.setString(1,process.getName());
            ps.setString(2,process.getType());
            ps.setObject(3, process.getDuration());
            ps.setInt(4,process.getPeriod());
            ps.setString(5,process.getPhase());
            ps.setString(6,process.getStatus());
            ps.setString(7,process.getObjective());
            ps.setObject(8,process.getOwner());
            ps.setString(9,process.getSubType());
            ps.setInt(10,process.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();

    }

    @Override
    public List<Process> query(SQLSpecification specification)  {
        Statement stm= null;

        String query=specification.toSqlClauses();

        List<Process> processes = new ArrayList<>();

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

                Process process=new Process();
                process.setId((Integer) newRow.get(0));
                process.setName((String) newRow.get(1));
                process.setType((String) newRow.get(2));
                process.setDuration((LocalDate)newRow.get(3));
                process.setPeriod((Integer)newRow.get(4));
                process.setPhase((String) newRow.get(5));
                process.setStatus((String) newRow.get(6));
                process.setObjective((String) newRow.get(7));

                process.setOwner((User) newRow.get(8));
                process.setSubType((String) newRow.get(9));

                processes.add(process);

            }
            rs.close ();
            stm.close ();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.getInstance().closeDBConnection();
        return processes;
    }

}
