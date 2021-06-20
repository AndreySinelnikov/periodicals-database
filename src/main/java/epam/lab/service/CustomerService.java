package epam.lab.service;

import epam.lab.dao.CustomerDaoImpl;
import epam.lab.domain.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CustomerService {

    public Customer create(String customerRecord) throws SQLException {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        String[] splitRecord = customerRecord.split(" ");
        Customer entry = new Customer(0, splitRecord[0], splitRecord[1], splitRecord[2], splitRecord[3], splitRecord[4]);

        ResultSet rs = customerDao.create(entry);
        rs.next();

        Customer created = new Customer(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"),
                rs.getString("middlename"), rs.getString("postcode"), rs.getString("address"));
        closeAssociatedResources(rs);
        return created;
    }

    public Customer update(String customerRecord) throws SQLException {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        String[] splitRecord = customerRecord.split(" ");
        Customer entry = new Customer(0, splitRecord[0], splitRecord[1], splitRecord[2], splitRecord[3], splitRecord[4]);

        ResultSet rs = customerDao.update(entry);
        rs.next();

        Customer created = new Customer(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"),
                rs.getString("middlename"), rs.getString("postcode"), rs.getString("address"));
        closeAssociatedResources(rs);
        return created;
    }

    public Customer getByLastname(String lastname) throws SQLException {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();

        ResultSet rs = customerDao.getByLastname(lastname);
        rs.next();

        Customer created = new Customer(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"),
                rs.getString("middlename"), rs.getString("postcode"), rs.getString("address"));
        closeAssociatedResources(rs);
        return created;
    }

    public Set<Customer> getAll() throws SQLException {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        Set<Customer> customerSet = new HashSet<>();

        ResultSet rs = customerDao.getAll();

        while (rs.next()) {
            Customer created = new Customer(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"),
                    rs.getString("middlename"), rs.getString("postcode"), rs.getString("address"));

            customerSet.add(created);
        }
        closeAssociatedResources(rs);
        return customerSet;
    }

    public Integer delete(Integer id) throws SQLException {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        return customerDao.delete(id);
    }

    public void closeAssociatedResources(ResultSet rs) throws SQLException {
            Statement st = rs.getStatement();
            Connection con = st.getConnection();
            rs.close();
            st.close();
            con.close();
    }
}
