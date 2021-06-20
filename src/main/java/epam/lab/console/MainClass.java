package epam.lab.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("I work... again");


        try {
            Class.forName("org.sqlite.JDBC");

            //Connection con = ConnectionFactory.getConnection();

            Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/sinel/EPAM/periodicals-database/src/main/resources/periodicals.db");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clients");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


