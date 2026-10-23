package org.codefilarete.model;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VisitTest {
    
    /**
     * Given a pet with an existing visit,
     * when we try to add a new visit that overlaps in time,
     * then it should throw an exception and not add the new visit.
     */
    @Test
    void addVisit_whenTimeSlotOverlapsExistingVisit_throwsException() {
        // Given
        Pet pet = new Pet();
        
        Visit existingVisit = new Visit();
        existingVisit.setStartTime(LocalDateTime.of(2026, 10, 23, 9, 0));
        existingVisit.setEndTime(LocalDateTime.of(2026, 10, 23, 10, 0));
        pet.addVisit(existingVisit);
        
        Visit overlappingVisit = new Visit();
        overlappingVisit.setStartTime(LocalDateTime.of(2026, 10, 23, 9, 30));
        overlappingVisit.setEndTime(LocalDateTime.of(2026, 10, 23, 10, 30));
        
        // When we try to add the overlapping visit, it should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> pet.addVisit(overlappingVisit));
    }
    
}