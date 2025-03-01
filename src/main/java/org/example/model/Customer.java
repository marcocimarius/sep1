package org.example.model;

import java.util.Objects;

/**
 * This class is responsible for storing the customers of a project.
 * @author Szymon Hajduk
 */
public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    /**
     * Constructs a new instance of Resources
     * @param name The name of the customer
     * @param phoneNumber The phone number of the customer
     * @param email The email of the customer
     * @param address The address of the customer
     */
    public Customer(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name sets name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for phoneNumber
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phoneNumber
     * @param phoneNumber sets phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     * @param email sets email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for address
     * @param address sets address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Indicates if another object is equal to this one
     * @param o the object to be compared with
     * @return {@code true} if the object are equal, {@code} false if the objects are not equal
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return name.equals(customer.name) && phoneNumber.equals(customer.phoneNumber) && email.equals(customer.email) && address.equals(customer.address);
    }

    /**
     * Returns a string representation of the object
     * @return the string representation of the object
     */
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
