package org.example.model;

import java.util.Objects;

/**
 * This class is responsible for storing the resources of a project.
 * @author Szymon Hajduk
 */
public class Resources {
    int hoursUsed;
    int hoursNeeded;
    double materialExpensedUsed;
    double materialExpensedNeeded;

    /**
     * Constructs a new instance of Resources
     * @param hoursUsed The hours used working on a project
     * @param hoursNeeded The hours needed working on a project
     * @param materialExpensedUsed The material expenses used while working on a project
     * @param materialExpensedNeeded The material expenses need to complete the project
     */
    public Resources(int hoursUsed, int hoursNeeded, double materialExpensedUsed, double materialExpensedNeeded) {
        this.hoursUsed = hoursUsed;
        this.hoursNeeded = hoursNeeded;
        this.materialExpensedUsed = materialExpensedUsed;
        this.materialExpensedNeeded = materialExpensedNeeded;
    }

    /**
     * Getter for hoursUsed
     * @return hoursUsed
     */
    public int getHoursUsed() {
        return hoursUsed;
    }

    /**
     * Setter for hoursUsed
     * @param hoursUsed sets hoursUsed
     */
    public void setHoursUsed(int hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    /**
     * Getter for hoursNeeded
     * @return hoursNeeded
     */
    public int getHoursNeeded() {
        return hoursNeeded;
    }

    /**
     * Setter for hoursNeeded
     * @param hoursNeeded sets hoursNeeded
     */
    public void setHoursNeeded(int hoursNeeded) {
        this.hoursNeeded = hoursNeeded;
    }

    /**
     * Getter for materialExpensedUsed
     * @return materialExpensedUsed
     */
    public double getMaterialExpensedUsed() {
        return materialExpensedUsed;
    }

    /**
     * Setter for materialExpensedUsed
     * @param materialExpensedUsed sets materialExpensedUsed
     */
    public void setMaterialExpensedUsed(double materialExpensedUsed) {
        this.materialExpensedUsed = materialExpensedUsed;
    }

    /**
     * Getter for materialExpensedNeeded
     * @return materialExpensedNeeded
     */
    public double getMaterialExpensedNeeded() {
        return materialExpensedNeeded;
    }

    /**
     * Setter for materialExpensedNeeded
     * @param materialExpensedNeeded sets materialExpensedNeeded
     */
    public void setMaterialExpensedNeeded(double materialExpensedNeeded) {
        this.materialExpensedNeeded = materialExpensedNeeded;
    }

    /**
     * Indicates if another object is equal to this one
     * @param o the object to be compared with
     * @return {@code true} if the object are equal, {@code} false if the objects are not equal
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resources resources)) return false;
        return hoursUsed == resources.hoursUsed && hoursNeeded == resources.hoursNeeded && Double.compare(resources.materialExpensedUsed, materialExpensedUsed) == 0 && Double.compare(resources.materialExpensedNeeded, materialExpensedNeeded) == 0;
    }

    /**
     * Returns a string representation of the object
     * @return the string representation of the object
     */
    public String toString() {
        return "Resources{" +
                "hoursUsed=" + hoursUsed +
                ", hoursNeeded=" + hoursNeeded +
                ", materialExpensedUsed=" + materialExpensedUsed +
                ", materialExpensedNeeded=" + materialExpensedNeeded +
                '}';
    }
}
