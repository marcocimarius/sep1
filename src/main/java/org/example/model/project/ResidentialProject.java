package org.example.model.project;

import org.example.model.Customer;
import org.example.model.Resources;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * This class is responsible for storing the residential projects.
 * @author Szymon Hajduk, Marius Marcoci
 */
public class ResidentialProject extends Project {
    private double size;
    private int numberOfKitchen;
    private int numberOfBathrooms;
    private int numberOfRoomsWithPlumbing;
    private boolean isRenovated;

    /**
     * Constructs a new instance of ResidentialProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param size the size of the project
     * @param numberOfKitchen the number of kitchens of the project
     * @param numberOfBathrooms the number of bathrooms of the project
     * @param numberOfRoomsWithPlumbing the number of rooms with plumbing of the project
     * @param isRenovated is the project renovated
     */
    public ResidentialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, String name, String timeline, double budget, double size, int numberOfKitchen, int numberOfBathrooms, int numberOfRoomsWithPlumbing, boolean isRenovated) {
        super(customer, resources, startDate, expectedEndDate, name, timeline, budget);
        this.size = size;
        this.numberOfKitchen = numberOfKitchen;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfRoomsWithPlumbing = numberOfRoomsWithPlumbing;
        this.isRenovated = isRenovated;
    }

    /**
     * Constructs a new instance of a ResidentialProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param size the size of the project
     * @param numberOfKitchen the number of kitchens of the project
     * @param numberOfBathrooms the number of bathrooms of the project
     * @param numberOfRoomsWithPlumbing the number of rooms with plumbing of the project
     * @param isRenovated is the project renovated
     */
    public ResidentialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, UUID id, String name, String timeline, double budget, double size, int numberOfKitchen, int numberOfBathrooms, int numberOfRoomsWithPlumbing, boolean isRenovated) {
        super(customer, resources, startDate, expectedEndDate, id, name, timeline, budget);
        this.size = size;
        this.numberOfKitchen = numberOfKitchen;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfRoomsWithPlumbing = numberOfRoomsWithPlumbing;
        this.isRenovated = isRenovated;
    }

    /**
     * Constructs a new instance of a ResidentialProject
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
     * @param numberOfKitchen the number of kitchens of the project
     * @param numberOfBathrooms the number of bathrooms of the project
     * @param numberOfRoomsWithPlumbing the number of rooms with plumbing of the project
     * @param isRenovated is the project renovated
     */
    public ResidentialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, UUID id, String name, String timeline, double budget, double size, int numberOfKitchen, int numberOfBathrooms, int numberOfRoomsWithPlumbing, boolean isRenovated) {
        super(customer, resources, startDate, expectedEndDate, endDate, id, name, timeline, budget);
        this.size = size;
        this.numberOfKitchen = numberOfKitchen;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfRoomsWithPlumbing = numberOfRoomsWithPlumbing;
        this.isRenovated = isRenovated;
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
     * Getter of numberOfKitchen
     * @return the numberOfKitchen
     */
    public int getNumberOfKitchen() {
        return numberOfKitchen;
    }

    /**
     * Setter for numberOfKitchen
     * @param numberOfKitchen the numberOfKitchen
     */
    public void setNumberOfKitchen(int numberOfKitchen) {
        this.numberOfKitchen = numberOfKitchen;
    }

    /**
     * Getter of numberOfBathrooms
     * @return the numberOfBathrooms
     */
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    /**
     * Setter for numberOfBathrooms
     * @param numberOfBathrooms the numberOfBathrooms
     */
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    /**
     * Getter of numberOfRoomsWithPlumbing
     * @return the numberOfRoomsWithPlumbing
     */
    public int getNumberOfRoomsWithPlumbing() {
        return numberOfRoomsWithPlumbing;
    }

    /**
     * Setter for numberOfRoomsWithPlumbing
     * @param numberOfRoomsWithPlumbing the numberOfRoomsWithPlumbing
     */
    public void setNumberOfRoomsWithPlumbing(int numberOfRoomsWithPlumbing) {
        this.numberOfRoomsWithPlumbing = numberOfRoomsWithPlumbing;
    }

    /**
     * Getter of isRenovated
     * @return isRenovated
     */
    public boolean isRenovated() {
        return isRenovated;
    }

    /**
     * Setter for isRenovated
     * @param renovated sets the isRenovated attribute
     */
    public void setRenovated(boolean renovated) {
        isRenovated = renovated;
    }

    /**
     * Indicates if another object is equal to this one
     * @param o the object to be compared with
     * @return {@code true} if the object are equal, {@code} false if the objects are not equal
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResidentialProject that)) return false;
        return size == that.size && numberOfKitchen == that.numberOfKitchen && numberOfBathrooms == that.numberOfBathrooms && numberOfRoomsWithPlumbing == that.numberOfRoomsWithPlumbing && isRenovated == that.isRenovated;
    }

    /**
     * Returns a string representation of the object
     * @return the string representation of the object
     */
    public String toString() {
        return getId().toString() + " " +
                getCustomer().toString() + " " +
                getResources().toString() + " " +
                getStartDate().toString() + " " +
                getExpectedEndDate().toString() + " " +
                ((getEndDate() != null) ? getEndDate().toString() : "null") + " " +
                "size=" + size +
                ", numberOfKitchen=" + numberOfKitchen +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfRoomsWithPlumbing=" + numberOfRoomsWithPlumbing +
                ", isRenovated=" + isRenovated +
                '}';
    }
}
