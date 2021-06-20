package epam.lab;

import epam.lab.console.CustomerConsoleOutput;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    Scanner intscan = new Scanner(System.in);
    Scanner stringscan = new Scanner(System.in);

    private void topMenu() throws SQLException {
        int option;

        do {
            System.out.println("""
                    Enter a number to select a table:
                    1: Customers
                    2: Publications
                    3: Subscriptions
                    4: Exit program
                    """);

            option = intscan.nextInt();
            switch (option) {
                case 1:
                    customerMenu();
                case 2:
                    System.out.println("Under construction");
                    break;
                case 3:
                    System.out.println("Under construction");
                    break;
                case 4:
                    System.out.println("Closing program");
                    break;
                default:
                    System.out.println("Wrong input");
            }
        } while (option != 4);
    }

    public void customerMenu() throws SQLException {
        int option;
        CustomerConsoleOutput output = new CustomerConsoleOutput();

        do {
            System.out.println("""
                    
                    Enter a number to select an operation:
                    1: Get subscriber's record by ID
                    2: Get all subscriber records

                    5: Back to main menu
                    """);

            option = intscan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter a subscriber's ID:");
                    Integer id = intscan.nextInt();
                    output.outputCustomer(id);
                    break;
                case 2:
                    output.outputAllCustomers();
                    break;
                case 5:
                    topMenu();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        } while (option != 5);

    }

    public static void main(String[] args) throws SQLException {
        MainMenu menu = new MainMenu();
        menu.topMenu();
    }
}
