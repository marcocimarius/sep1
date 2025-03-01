package org.example.model.project;

import org.example.model.Customer;
import org.example.model.Resources;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * This class is responsible for storing the road construction projects.
 * @author Szymon Hajduk, Marius Marcoci
 */
public class RoadConstructionProject extends Project {
    private double length;
    private double width;
    private int numberOfBridge;
    private int numberOfTunnels;
    private String envOrGeoChallenges;

    /**
     * Constructs a new instance of RoadConstructionProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param length the length of the project
     * @param width the width of the project
     * @param numberOfBridge the number of bridges of the project
     * @param numberOfTunnels the number of tunnels of the project
     * @param envOrGeoChallenges the number of environmental or geographical challenges for the project
     */
    public RoadConstructionProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, String name, String timeline, double budget, double length, double width, int numberOfBridge, int numberOfTunnels, String envOrGeoChallenges) {
        super(customer, resources, startDate, expectedEndDate, name, timeline, budget);
        this.length = length;
        this.width = width;
        this.numberOfBridge = numberOfBridge;
        this.numberOfTunnels = numberOfTunnels;
        this.envOrGeoChallenges = envOrGeoChallenges;
    }

    /**
     * Constructs a new instance of a RoadConstructionProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param length the length of the project
     * @param width the width of the project
     * @param numberOfBridge the number of bridges of the project
     * @param numberOfTunnels the number of tunnels of the project
     * @param envOrGeoChallenges the number of environmental or geographical challenges for the project
     */
    public RoadConstructionProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, UUID id, String name, String timeline, double budget, double length, double width, int numberOfBridge, int numberOfTunnels, String envOrGeoChallenges) {
        super(customer, resources, startDate, expectedEndDate, id, name, timeline, budget);
        this.length = length;
        this.width = width;
        this.numberOfBridge = numberOfBridge;
        this.numberOfTunnels = numberOfTunnels;
        this.envOrGeoChallenges = envOrGeoChallenges;
    }

    /**
     * Constructs a new instance of a RoadConstructionProject
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param endDate the end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     * @param length the length of the project
     * @param width the width of the project
     * @param numberOfBridge the number of bridges of the project
     * @param numberOfTunnels the number of tunnels of the project
     * @param envOrGeoChallenges the number of environmental or geographical challenges for the project
     */
    public RoadConstructionProject(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, UUID id, String name, String timeline, double budget, double length, double width, int numberOfBridge, int numberOfTunnels, String envOrGeoChallenges) {
        super(customer, resources, startDate, expectedEndDate, endDate, id, name, timeline, budget);
        this.length = length;
        this.width = width;
        this.numberOfBridge = numberOfBridge;
        this.numberOfTunnels = numberOfTunnels;
        this.envOrGeoChallenges = envOrGeoChallenges;
    }

    /**
     * Getter of length
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * Setter for length
     * @param length the length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Getter of width
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setter for width
     * @param width the width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Getter of numberOfBridge
     * @return the numberOfBridge
     */
    public int getNumberOfBridge() {
        return numberOfBridge;
    }

    /**
     * Setter for numberOfBridge
     * @param numberOfBridge the numberOfBridge
     */
    public void setNumberOfBridge(int numberOfBridge) {
        this.numberOfBridge = numberOfBridge;
    }

    /**
     * Getter of numberOfTunnels
     * @return the numberOfTunnels
     */
    public int getNumberOfTunnels() {
        return numberOfTunnels;
    }

    /**
     * Setter for numberOfTunnels
     * @param numberOfTunnels the numberOfTunnels
     */
    public void setNumberOfTunnels(int numberOfTunnels) {
        this.numberOfTunnels = numberOfTunnels;
    }

    /**
     * Getter of envOrGeoChallenges
     * @return the envOrGeoChallenges
     */
    public String getEnvOrGeoChallenges() {
        return envOrGeoChallenges;
    }

    /**
     * Setter for envOrGeoChallenges
     * @param envOrGeoChallenges the envOrGeoChallenges
     */
    public void setEnvOrGeoChallenges(String envOrGeoChallenges) {
        this.envOrGeoChallenges = envOrGeoChallenges;
    }

    /**
     * Indicates if another object is equal to this one
     * @param o the object to be compared with
     * @return {@code true} if the object are equal, {@code} false if the objects are not equal
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoadConstructionProject that)) return false;
        if (!super.equals(o)) return false;
        return length == that.length && width == that.width && numberOfBridge == that.numberOfBridge && numberOfTunnels == that.numberOfTunnels && envOrGeoChallenges.equals(that.envOrGeoChallenges);
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
                "length=" + length +
                ", width=" + width +
                ", numberOfBridge=" + numberOfBridge +
                ", numberOfTunnels=" + numberOfTunnels +
                ", envOrGeoChallanges='" + envOrGeoChallenges + '\'' +
                '}';
    }
}
