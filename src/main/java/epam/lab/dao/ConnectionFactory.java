package epam.lab.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String url = "jdbc:sqlite:C:/Users/sinel/EPAM/periodicals-database" +
            "src/main/resources/periodicals.db";


    public static Connection getConnection() {
        try {
            //Class.forName("org.sqlite.JDBC");
            //DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }


    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();

    }
}