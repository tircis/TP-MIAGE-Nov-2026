package org.codefilarete.miage.domain.inbound;

import java.time.LocalDateTime;

public record VisitDTO(
    Integer id,
    String description,
    LocalDateTime startTime,
    LocalDateTime endTime
) {
}
