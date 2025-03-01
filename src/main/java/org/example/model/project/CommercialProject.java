package org.example.model.project;

import org.example.model.Customer;
import org.example.model.Resources;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * This class is responsible for storing the commercial projects.
 * @author Szymon Hajduk, Marius Marcoci
 */
public class CommercialProject extends Project {
    private double size;
    private int numberOfFloors;
    private String intendedUseOfBuilding;

    /**
     * Constructs a new instance of CommercialProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param size the size of the project
     * @param numberOfFloors the number of floors of the project
     * @param intendedUseOfBuilding the intended use of the project
     */
    public CommercialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, String name, String timeline, double budget, double size, int numberOfFloors, String intendedUseOfBuilding) {
        super(customer, resources, startDate, expectedEndDate, name, timeline, budget);
        this.size = size;
        this.numberOfFloors = numberOfFloors;
        this.intendedUseOfBuilding = intendedUseOfBuilding;
    }

    /**
     * Constructs a new instance of a CommercialProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param size the size of the project
     * @param numberOfFloors the number of floors of the project
     * @param intendedUseOfBuilding the intended use of the project
     */
    public CommercialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, UUID id, String name, String timeline, double budget, double size, int numberOfFloors, String intendedUseOfBuilding) {
        super(customer, resources, startDate, expectedEndDate, id, name, timeline, budget);
        this.size = size;
        this.numberOfFloors = numberOfFloors;
        this.intendedUseOfBuilding = intendedUseOfBuilding;
    }

    /**
     * Constructs a new instance of a CommercialProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param endDate the end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param size the size of the project
     * @param numberOfFloors the number of floors of the project
     * @param intendedUseOfBuilding the intended use of the project
     */
    public CommercialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, UUID id, String name, String timeline, double budget, double size, int numberOfFloors, String intendedUseOfBuilding) {
        super(customer, resources, startDate, expectedEndDate, endDate, id, name, timeline, budget);
        this.size = size;
        this.numberOfFloors = numberOfFloors;
        this.intendedUseOfBuilding = intendedUseOfBuilding;
    }

    /**
     * Getter of size
     * @return the size
     */
    public double getSize() {
        return size;
    }

    /**
     * Setter for size
     * @param size the size
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Getter of numberOfFloors
     * @return the numberOfFloors
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Setter for numberOfFloors
     * @param numberOfFloors the numberOfFloors
     */
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    /**
     * Getter of intendedUseOfBuilding
     * @return the intendedUseOfBuilding
     */
    public String getIntendedUseOfBuilding() {
        return intendedUseOfBuilding;
    }

    /**
     * Setter for intendedUseOfBuilding
     * @param intendedUseOfBuilding the intendedUseOfBuilding
     */
    public void setIntendedUseOfBuilding(String intendedUseOfBuilding) {
        this.intendedUseOfBuilding = intendedUseOfBuilding;
    }

    /**
     * Indicates if another object is equal to this one
     * @param o the object to be compared with
     * @return {@code true} if the object are equal, {@code} false if the objects are not equal
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommercialProject that)) return false;
        if (!super.equals(o)) return false;
        return size == that.size && numberOfFloors == that.numberOfFloors && intendedUseOfBuilding.equals(that.intendedUseOfBuilding);
    }

    /**
     * Returns a string representation of the object
     * @return the string representation of the object
     */
    public String toString() {
        return  getId().toString()+" "+
                getCustomer().toString() +" "+
                getResources().toString() +" "+
                getStartDate().toString() +" "+
                getExpectedEndDate().toString() +" "+
                ((getEndDate() != null) ? getEndDate().toString() : "null") +" "+
                "CommercialProject{" +
                "size=" + size +
                ", numberOfFloors=" + numberOfFloors +
                ", intendedUseOfBuilding='" + intendedUseOfBuilding + '\'' +
                '}';
    }
}