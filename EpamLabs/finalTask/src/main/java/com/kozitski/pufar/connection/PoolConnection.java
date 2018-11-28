package com.kozitski.pufar.connection;

import com.kozitski.pufar.exception.PufarDAOException;
import com.kozitski.pufar.util.path.WebPathReturner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class PoolConnection {
    private static Logger LOGGER = LoggerFactory.getLogger(PoolConnection.class);
    private static final String PROPERTY_PATH = "/WEB-INF/classes/pooll/poolConnection.properties";

    private static final int MIN_POOL_CAPACITY = 5;
    private static final int MAX_POOL_CAPACITY = 20;
    private static final int INITIAL_CAPACITY = 10;

    private ArrayBlockingQueue<Connection> freeConnections = new ArrayBlockingQueue<>(MAX_POOL_CAPACITY);
    private ArrayBlockingQueue<Connection> releaseConnections = new ArrayBlockingQueue<>(MAX_POOL_CAPACITY);

    private static ReentrantLock lock = new ReentrantLock();
    private static PoolConnection poolConnection;
    public static PoolConnection getInstance() throws PufarDAOException {
        if(poolConnection != null){
            return poolConnection;
        }

        try {
            lock.lock();
            if(poolConnection == null){
                try {
                    poolConnection = new PoolConnection();
                } catch (SQLException e) {
                    throw new PufarDAOException("Can not get Instance", e);
                }
            }
        }
        finally {
            lock.unlock();
        }

        return poolConnection;
    }

    private PoolConnection() throws SQLException, PufarDAOException {
        DriverManager.registerDriver(new Driver());

        init();
    }
    private void init() throws PufarDAOException {

        String fullPath = (WebPathReturner.webPath + PROPERTY_PATH);
        Properties properties = new Properties();

        try(FileInputStream fileInputStream = new FileInputStream(fullPath)) {
            properties.load(fileInputStream);
            ConnectionAttribute[] connectionAttributes = ConnectionAttribute.values();
            for(ConnectionAttribute connectionAttribute : connectionAttributes){
                connectionAttribute.setValue(properties.getProperty(connectionAttribute.toString()));
            }

        }
        catch (IOException e) {
            LOGGER.error("Error while reading properties", e);
        }

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            try {
                freeConnections.add(new ProxyConnection(DriverManager.getConnection(ConnectionAttribute.CONNECTION_URL.getValue(),
                        ConnectionAttribute.USER_LOGIN.getValue(),ConnectionAttribute.USER_PASSWORD.getValue())));
            }
            catch (SQLException e) {
                throw new PufarDAOException("Pool can not initialize", e);
            }
        }

    }

    public Connection getConnection() throws PufarDAOException {

        try {
            lock.lock();

            Connection connection;

            if(freeConnections.size() < MIN_POOL_CAPACITY && (freeConnections.size() + releaseConnections.size()) < MAX_POOL_CAPACITY){
                connection = new ProxyConnection(DriverManager.getConnection(ConnectionAttribute.CONNECTION_URL.getValue(),
                        ConnectionAttribute.USER_LOGIN.getValue(),ConnectionAttribute.USER_PASSWORD.getValue()));
                releaseConnections.offer(connection);
            }
            else {
                connection = freeConnections.take();
            }

            return connection;
        }
        catch (InterruptedException | SQLException e) {
            throw new PufarDAOException("Can not get connection", e);
        }
        finally {
            lock.unlock();
        }

    }
    void releaseConnection(Connection connection) throws SQLException {

        try {
            lock.lock();

            if(freeConnections.size() > MIN_POOL_CAPACITY + INITIAL_CAPACITY){
                ((ProxyConnection)connection).realClose();
                for (int i = 0; i < MIN_POOL_CAPACITY - 1; i++) {
                    ((ProxyConnection) freeConnections.take()).realClose();
                }
            }
            else {
                freeConnections.offer(connection);
            }
        } catch (InterruptedException e) {
            LOGGER.error("connection take fell down", e);
        } finally {
            lock.unlock();
        }

    }
    public void destroy(){
        try {
            lock.lock();

            for(Connection connection : freeConnections){
                ((ProxyConnection)connection).realClose();
            }
            for(Connection connection : releaseConnections){
                ((ProxyConnection)connection).realClose();
            }
            poolConnection = null;
        } catch (SQLException e) {
            LOGGER.error("Can not close connection", e);
        } finally {
            lock.unlock();
        }
    }

}
