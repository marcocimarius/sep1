package org.example.model.project;

import org.example.model.Customer;
import org.example.model.Resources;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
/**
 * This abstract class serves as base for all the projects.
 * @author Szymon Hajduk, Marius Marcoci
 */
public abstract class Project {
    private Customer customer;
    private Resources resources;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate expectedEndDate;
    private final UUID id;
    private String name;
    private String timeline;
    private double budget;

    private String type;

    /**
     * Constructs a new instance of Project
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     */
    public Project(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, String name, String timeline, double budget) {
        this.customer = customer;
        this.resources = resources;
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.endDate = null;
        this.id = UUID.randomUUID();
        this.name = name;
        this.timeline = timeline;
        this.budget = budget;
    }

    /**
     * Constructs a new instance of a Project
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     */
    public Project(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, UUID id, String name, String timeline, double budget) {
        this.customer = customer;
        this.resources = resources;
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.endDate = null;
        this.id = id;
        this.name = name;
        this.timeline = timeline;
        this.budget = budget;
    }

    /**
     * Constructs a new instance of a Project
     * @param customer the customer of the project
     * @param resources the resources of the project
     * @param startDate the start date of the project
     * @param expectedEndDate the expected end date of the project
     * @param endDate the end date of the project
     * @param id the id of the project
     * @param name the name of the project
     * @param timeline the timeline of the project
     * @param budget the budget of the project
     */
    public Project(Customer customer, Resources resources, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, UUID id, String name, String timeline, double budget) {
        this.customer = customer;
        this.resources = resources;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expectedEndDate = expectedEndDate;
        this.id = id;
        this.name = name;
        this.timeline = timeline;
        this.budget = budget;
    }

    /**
     * Getter of customer
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for customer
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter of resources
     * @return the resources
     */
    public Resources getResources() {
        return resources;
    }

    /**
     * Setter for resources
     * @param resources the resources
     */
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    /**
     * Getter of startDate
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Getter of endDate
     * @return the endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Getter of expectedEndDate
     * @return the expectedEndDate
     */
    public LocalDate getExpectedEndDate() {
        return expectedEndDate;
    }

    /**
     * Setter for expectedEndDate
     * @param expectedEndDate the expectedEndDate
     */
    public void setExpectedEndDate(LocalDate expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    /**
     * Setter for startDate
     * @param localDate the startDate
     */
    public void setStartDate(LocalDate localDate) {
        this.startDate = localDate;
    }

    /**
     * Setter for endDate
     * @param localDate the endDate
     */
    public void setEndDate(LocalDate localDate) {
        this.endDate = localDate;
    }

    /**
     * Getter of id
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Getter of name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of timeline
     * @return the timeline
     */
    public String getTimeline() {
        return timeline;
    }

    /**
     * Setter for timeline
     * @param timeline the timeline
     */
    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    /**
     * Getter of budget
     * @return the budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Setter for budget
     * @param budget the budget
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * Getter of the type of the project
     * @return the type of the project
     */
    public String getType() {
        if (this instanceof ResidentialProject) {
            return "Residential";
        }
        if (this instanceof CommercialProject) {
            return "Commercial";
        }
        if (this instanceof RoadConstructionProject) {
            return "Road Construction";
        }
        if (this instanceof IndustrialProject) {
            return "Industrial";
        }
        return "Unknown";
    }

    /**
     * Check if the project is residential
     * @param project the project to be checked
     * @return {@code true} if the project is residential, {@code false} if the project is not residential
     */
    public static boolean isResidential(Project project) {
        if (project instanceof ResidentialProject) {
            return true;
        }
        return false;
    }

    /**
     * Check if the project is commercial
     * @param project the project to be checked
     * @return {@code true} if the project is commercial, {@code false} if the project is not commercial
     */
    public static boolean isCommercial(Project project) {
        if (project instanceof CommercialProject) {
            return true;
        }
        return false;
    }

    /**
     * Check if the project is road construction
     * @param project the project to be checked
     * @return {@code true} if the project is road construction, {@code false} if the project is not road construction
     */
    public static boolean isRoadConstruction(Project project) {
        if (project instanceof RoadConstructionProject) {
            return true;
        }
        return false;
    }

    /**
     * Check if the project is industrial
     * @param project the project to be checked
     * @return {@code true} if the project is industrial, {@code false} if the project is not industrial
     */
    public static boolean isIndustrial(Project project) {
        if (project instanceof IndustrialProject) {
            return true;
        }
        return false;
    }

    /**
     * Finds the type of the project
     * @param project the project to be checked
     * @return the class name of the project
     */
    public String prepareType(Project project) {
        if (project instanceof ResidentialProject) {
            return formatString(ResidentialProject.class.toString());
        }
        if (project instanceof CommercialProject) {
            return formatString(CommercialProject.class.toString());
        }
        if (project instanceof RoadConstructionProject) {
            return formatString(RoadConstructionProject.class.toString());
        }
        if (project instanceof IndustrialProject) {
            return formatString(IndustrialProject.class.toString());
        }
        throw new IllegalArgumentException("You should not be here! Project type not found");
    }

    /**
     * Returns the type of the project
     * @param name the class name of the project
     * @return the type of the project
     */
    public String formatString(String name) {
        return name.split("\\.")[4].replace("Project", "").trim();
    }

    /**
     * Indicates if another object is equal to this one
     * @param o the object to be compared with
     * @return {@code true} if the object are equal, {@code} false if the objects are not equal
     */
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Project temp = (Project) o;

        if (temp.endDate == null && this.endDate == null) {
            return temp.budget == this.budget && temp.customer.equals(this.customer) && temp.resources.equals(this.resources) && temp.startDate.equals(this.startDate) && temp.expectedEndDate.equals(this.expectedEndDate) && temp.id.equals(this.id) && temp.name.equals(this.name) && temp.timeline.equals(this.timeline);
        }

        return temp.budget == this.budget && temp.customer.equals(this.customer) && temp.resources.equals(this.resources) && temp.startDate.equals(this.startDate) && temp.endDate.equals(this.endDate) && temp.expectedEndDate.equals(this.expectedEndDate) && temp.id.equals(this.id) && temp.name.equals(this.name) && temp.timeline.equals(this.timeline);
    }

    /**
     * Returns a string representation of the object
     * @return the string representation of the object
     */
    public String toString() {
        return "Project{" +
                "customer=" + customer +
                ", resources=" + resources +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", expectedEndDate=" + expectedEndDate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", timeline='" + timeline + '\'' +
                ", budget=" + budget +
                '}';
    }
}