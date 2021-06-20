package epam.lab.dao;

import epam.lab.domain.Customer;

import java.sql.*;

public class CustomerDaoImpl implements CrudDao<Customer> {
    public static final String URL = "jdbc:sqlite:C:/Users/sinel/EPAM/periodicals-database/src/main/resources/periodicals.db";
    private final Connection con;

    public CustomerDaoImpl() throws SQLException {
        this.con = DriverManager.getConnection(URL);
        this.con.setAutoCommit(true);
    }

    public ResultSet get(Integer id) throws SQLException {
        Statement st = con.createStatement();

        return st.executeQuery("SELECT * FROM clients WHERE id = '" + id + "'");
    }

    @Override
    public ResultSet getAll() throws SQLException {
        Statement st = con.createStatement();

        return st.executeQuery("SELECT * FROM clients;");
    }

    @Override
    public ResultSet update(Customer customer) throws SQLException {
        String query = "UPDATE clients SET lastname = ?, firstname = ?, middlename = ?, postcode = ?, address = ? WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, customer.getLastname());
        ps.setString(2, customer.getFirstname());
        ps.setString(3, customer.getMiddlename());
        ps.setString(4, customer.getPostcode());
        ps.setString(5, customer.getAddress());
        ps.setInt(6, customer.getId());
        ps.executeUpdate();

        return this.get(customer.getId());
    }

    @Override
    public ResultSet create(Customer customer) throws SQLException {
        String query = "INSERT INTO clients (lastname, firstname, middlename, postcode, address) VALUES" +
                "(?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, customer.getLastname());
        ps.setString(2, customer.getFirstname());
        ps.setString(3, customer.getMiddlename());
        ps.setString(4, customer.getPostcode());
        ps.setString(5, customer.getAddress());
        ps.executeUpdate();

        return this.get(customer.getId());
    }

    @Override
    public Integer delete(Integer id) throws SQLException {
        String query = "DELETE FROM SUBSCRIBERS WHERE ID = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        return ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        CustomerDaoImpl cus = new CustomerDaoImpl();
        ResultSet rs = cus.get(1);
        //rs.next();
        System.out.println(rs.getString("lastname"));
    }
}

