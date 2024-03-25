//7. Create a utility class DBConnection in a package util with a static variable connection of Type
//Connection and a static method getConnection() which returns connection.
//Connection properties supplied in the connection string should be read from a property file.
package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                String connectionString = DBPropertyUtil.getPropertyFilePath();
                connection = DriverManager.getConnection(connectionString);
                System.out.println("Database connection established.");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SQLException("Failed to establish Connection.", e);
            }
        }
        return connection;
    }
}
