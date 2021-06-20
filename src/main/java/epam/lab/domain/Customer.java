package epam.lab.domain;

public class Customer {


    private Integer id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String postcode;
    private String address;

    public Customer(Integer id, String firstname, String lastname, String middlename, String postcode, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.postcode = postcode;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return String.format("ID: %s, Name: %s %s %s, Postcode: %s, Address: %s",
                id, lastname, firstname, middlename, postcode, address);
    }
}
