package com.kozitski.pufar.connection;

import com.kozitski.pufar.exception.PufarDAOException;

import java.sql.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class PoolConnection {
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/pufar?serverTimezone=UTC&useSSL=false";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "123ghu475R7px6";

    private CopyOnWriteArrayList<Connection> connections = new CopyOnWriteArrayList<>();

    private int initialCapacity = 10;

    private static ReentrantLock lock = new ReentrantLock();
    private static PoolConnection poolConnection;
    public static PoolConnection getInstance(String url, String user, String password) throws SQLException {
        if(poolConnection != null){
            return poolConnection;
        }

        try {
            lock.lock();
            if(poolConnection == null){
                poolConnection = new PoolConnection(url, user, password);
            }
        }
        finally {
            lock.unlock();
        }

        return poolConnection;
    }
    public static PoolConnection getInstance() throws SQLException {
        return getInstance(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
    }

    private PoolConnection(String url, String user, String password) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < initialCapacity ; i++) {
            connections.add(new ProxyConnection(DriverManager.getConnection(url, user, password)));
        }

        init();
    }
    private void init() throws SQLException {

    }


    public Connection getConnection() throws PufarDAOException {

        // сделать увеличение кол-ва конестионс по неким параметрам (также и с уменьшением)
        if(connections.size() < 1){
            throw new PufarDAOException("");
        }

        Connection connection = connections.get(0);
        connections.remove(0);
        return connection;
    }
    public void releaseConnection(Connection connection){
        connections.add(connection);
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }
    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

}
