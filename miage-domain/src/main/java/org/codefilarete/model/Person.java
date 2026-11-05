package org.codefilarete.model;

/**
 * Simple JavaBean domain object representing an person.
 *
 * @author Ken Krebs
 */
public class Person extends BaseEntity {

    protected String firstName;

    protected String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
