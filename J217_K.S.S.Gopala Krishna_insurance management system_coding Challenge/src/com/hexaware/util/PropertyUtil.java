//Create a utility class PropertyUtil which contains a static method named getPropertyString() which
//reads a property fie containing connection details like hostname, dbname, username, password, port
//number and returns a connection string.
package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	 public static String getPropertyString() {
	        Properties properties = new Properties();
	        try (FileInputStream fileInputStream = new FileInputStream(DBPropertyUtil.getPropertyFilePath())) {
	            properties.load(fileInputStream);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load property file.", e);
	        }

	        String hostname = properties.getProperty("hostname");
	        String dbName = properties.getProperty("dbname");
	        String username = properties.getProperty("username");
	        String password = properties.getProperty("password");
	        String port = properties.getProperty("port");

	        return "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + username + "&password=" + password;
	    }
}
