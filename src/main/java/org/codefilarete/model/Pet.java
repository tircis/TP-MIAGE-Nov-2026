package org.codefilarete.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Simple business object representing a pet.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 */
public class Pet extends NamedEntity {

    private LocalDate birthDate;

    private PetType type;

    private Owner owner;

    private Set<Visit> visits;

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getType() {
        return this.type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    protected Set<Visit> getVisitsInternal() {
        if (this.visits == null) {
            this.visits = new HashSet<>();
        }
        return this.visits;
    }

    protected void setVisitsInternal(Set<Visit> visits) {
        this.visits = visits;
    }
    
    public Collection<Visit> getVisits() {
        return Collections.unmodifiableCollection(visits);
    }
    
    public void setVisits(List<Visit> visits) {
        this.visits = new HashSet<>(visits);
    }
    
    public void addVisit(Visit visit) {
        for (Visit existingVisit : getVisitsInternal()) {
            if (existingVisit.getStartTime().isBefore(visit.getEndTime())
                    && visit.getStartTime().isBefore(existingVisit.getEndTime())) {
                throw new IllegalArgumentException("Visit time range overlaps an existing visit");
            }
        }
        getVisitsInternal().add(visit);
        visit.setPet(this);
    }

}
