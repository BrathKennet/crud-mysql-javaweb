package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    Connection con;

    public Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultad","root","admin123");
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }
    }

    public Connection getConnection() {
        return con;
    }

}
