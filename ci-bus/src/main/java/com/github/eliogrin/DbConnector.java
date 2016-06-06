package com.github.eliogrin;

import com.mysql.jdbc.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private Logger log = LoggerFactory.getLogger(DbConnector.class);
    private Connection connection;
    private Sql2o connectionDao;

    public DbConnector(String connectionString, String user, String password) {
        registerDriver();
        connectionDao = new Sql2o(connectionString, user, password);
        connection = connectionDao.open();
        log.info("Connected to database @ {}", connectionString);
    }

    private void registerDriver() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            log.error("Failed to register My SQL driver.");
        }
    }

    public Connection beginTransaction() {
        return connectionDao.beginTransaction();
    }

    public Connection instance() {
        return connection;
    }
}
