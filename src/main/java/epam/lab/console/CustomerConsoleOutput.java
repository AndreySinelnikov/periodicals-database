package epam.lab.console;

import epam.lab.domain.Customer;
import epam.lab.service.CustomerService;

import java.sql.SQLException;
import java.util.Set;

public class CustomerConsoleOutput {
    CustomerService service = new CustomerService();

    public void outputCustomer(Integer id) throws SQLException {
        try {
            Customer customer = service.getById(id);
            System.out.println(customer.toString());
        } catch (SQLException e) {
            System.out.println("Invalid ID");
        }
    }

    public void outputAllCustomers() throws SQLException {
        Set<Customer> set = service.getAll();
        for (Customer c: set) {
            System.out.println(c.toString());
        }
    }

    public void outputCustomerCreation(String record) throws SQLException {
        try {
            Customer customer = service.create(record);
            System.out.println("Customer record successfully created!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input format");
        } catch (SQLException e) {
            System.out.println("Customer record creation failed");
            System.out.println(e.getMessage());
        }
    }
}
