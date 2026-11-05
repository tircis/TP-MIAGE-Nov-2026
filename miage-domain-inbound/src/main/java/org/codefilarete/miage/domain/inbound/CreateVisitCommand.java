package org.codefilarete.miage.domain.inbound;

import java.time.LocalDateTime;

public record CreateVisitCommand(
    String description,
    LocalDateTime startTime,
    LocalDateTime endTime
) {
}
