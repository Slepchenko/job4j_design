package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException {
        Class.forName(properties.getProperty("driver_class"));
        try {
            this.connection =DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) throws Exception {
        action(String.format(
                "create table if not exists %s (%s, %s);",
                tableName,
                "id serial primary key",
                "name text"
        ));
    }

    public void dropTable(String tableName) throws Exception {
        action("drop table " + tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        action(String.format(
                "alter table %s add %s %s;",
                tableName,
                columnName,
                type
        ));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        action(String.format(
                "alter table %s drop column %s;",
                tableName,
                columnName
        ));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        action(String.format(
                "alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        ));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private void action(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}