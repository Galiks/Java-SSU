package com.turchenkov.dao.database;

import com.turchenkov.dao.ItemDAO;
import com.turchenkov.model.Item;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class ConnectDatabase implements ItemDAO {

    private Connection connection;

    private String url;
    private String username;
    private String password;

    public ConnectDatabase() {
        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\IDEAUltimate\\Projects\\JDBC\\jdbc\\src\\main\\resources\\application.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String driverClassName = properties.getProperty("datasource.driverClassName");
            url = properties.getProperty("datasource.url");
            username = properties.getProperty("datasource.username");
            password = properties.getProperty("datasource.password");

            Class.forName(driverClassName);

            connection = DriverManager.getConnection(url, username, password);

            createItemTable();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createItemTable() {
        String sqlQuery = "CREATE TABLE IF NOT EXISTS ITEM (" +
                "ID VARCHAR(255) not NULL," +
                "NAME VARCHAR(255) not NULL," +
                "MONEY INT not NULL," +
                "PRIMARY KEY ( ID )" +
                ")";
        createTableExecutor(sqlQuery);
    }

    private void createTableExecutor(String sqlQuery) {
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getItems() throws IOException {
        List<Item> all = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ITEM");
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String name = resultSet.getString("NAME");
                int money = resultSet.getInt("MONEY");

                all.add(new Item(id, name, money));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public void addItem(Item item) throws IOException {
        item.setId(String.valueOf(UUID.randomUUID()));
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sqlEx = "INSERT INTO ITEM (ID, NAME, MONEY) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlEx);
            preparedStatement.setString(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, item.getMoney());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
