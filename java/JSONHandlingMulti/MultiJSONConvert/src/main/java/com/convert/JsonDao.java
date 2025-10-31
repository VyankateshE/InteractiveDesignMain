package com.convert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JsonDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/interactive_designer_html_template";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Vishal@007#";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            // Proper exception handling needed here
            e.printStackTrace();
        }
        return null;
    }

    public static String getPath(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            if (connection != null) {
                String sql = "SELECT path_of_editable_html FROM user WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                // Check if the result set contains any rows
                if (resultSet.next()) {
                    return resultSet.getString("path_of_editable_html");
                } else {
                    // Handle case where no rows are returned
                    // You can throw an exception or return a default value
                    // For now, let's return null
                    return null;
                }
            }
        } catch (Exception e) {
            // Proper exception handling needed here
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // Proper exception handling needed here
                e.printStackTrace();
            }
        }
        return null;
    }
}
