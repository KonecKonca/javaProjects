package com.kozitski.pufar.connection;

import java.sql.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class PoolConnection {
    private CopyOnWriteArrayList<Connection> available = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Connection> used = new CopyOnWriteArrayList<>();

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
    private PoolConnection(String url, String user, String password) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < initialCapacity ; i++) {
            available.add(DriverManager.getConnection(url, user, password));
        }

        init();
    }
    private void init() throws SQLException {

    }
    public Connection getConnection(){
        return available.get(0);
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }
    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

}
