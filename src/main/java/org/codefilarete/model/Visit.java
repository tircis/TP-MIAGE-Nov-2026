package org.codefilarete.model;

import java.time.LocalDateTime;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 */
public class Visit extends BaseEntity {

    /**
     * Holds value of property description.
     */
    private String description;

    /**
     * Holds value of property pet.
     */
    private Pet pet;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    
    /**
     * Creates a new instance of Visit for the current date
     */
    public Visit() {
    
    }

    /**
     * Getter for property description.
     *
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description.
     *
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property pet.
     *
     * @return Value of property pet.
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * Setter for property pet.
     *
     * @param pet New value of property pet.
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
