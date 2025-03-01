package org.example.model.project;

import org.example.model.Customer;
import org.example.model.Resources;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class is responsible for storing the industrial projects.
 * @author Szymon Hajduk, Marius Marcoci
 */
public class IndustrialProject extends Project {

    private double size;
    private String typeOfIndustrialFacility;

    /**
     * Constructs a new instance of IndustrialProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param size the size of the project
     * @param typeOfIndustrialFacility the type of the industrial facility of the project
     */
    public IndustrialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, String name, String timeline, double budget, double size, String typeOfIndustrialFacility) {
        super(customer, resources, startDate, expectedEndDate, name, timeline, budget);
        this.size = size;
        this.typeOfIndustrialFacility = typeOfIndustrialFacility;
    }

    /**
     * Constructs a new instance of a IndustrialProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param size the size of the project
     * @param typeOfIndustrialFacility the type of the industrial facility of the project
     */
    public IndustrialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, UUID id, String name, String timeline, double budget, double size, String typeOfIndustrialFacility) {
        super(customer, resources, startDate, expectedEndDate, id, name, timeline, budget);
        this.size = size;
        this.typeOfIndustrialFacility = typeOfIndustrialFacility;
    }

    /**
     * Constructs a new instance of a IndustrialProject
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
     * @param typeOfIndustrialFacility the type of the industrial facility of the project
     */
    public IndustrialProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, UUID id, String name, String timeline, double budget, double size, String typeOfIndustrialFacility) {
        super(customer, resources, startDate, expectedEndDate, endDate, id, name, timeline, budget);
        this.size = size;
        this.typeOfIndustrialFacility = typeOfIndustrialFacility;
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
     * Getter of typeOfIndustrialFacility
     * @return the typeOfIndustrialFacility
     */
    public String getTypeOfIndustrialFacility() {
        return typeOfIndustrialFacility;
    }

    /**
     * Setter for typeOfIndustrialFacility
     * @param typeOfIndustrialFacility the typeOfIndustrialFacility
     */
    public void setTypeOfIndustrialFacility(String typeOfIndustrialFacility) {
        this.typeOfIndustrialFacility = typeOfIndustrialFacility;
    }

    /**
     * Indicates if another object is equal to this one
     * @param o the object to be compared with
     * @return {@code true} if the object are equal, {@code} false if the objects are not equal
     */
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        IndustrialProject temp = (IndustrialProject) o;

        return super.equals(temp) && this.size == temp.size && this.typeOfIndustrialFacility.equals(temp.typeOfIndustrialFacility);
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
                " IndustrialProject{" +
                "size=" + size +
                ", typeOfIndustrialFacility='" + typeOfIndustrialFacility + '\'' +
                '}';
    }
}
