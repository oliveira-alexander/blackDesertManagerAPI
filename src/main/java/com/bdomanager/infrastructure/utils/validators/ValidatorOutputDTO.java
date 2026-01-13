package com.bdomanager.infrastructure.utils.validators;

import java.time.LocalDateTime;
import java.util.List;

public record ValidatorOutputDTO(
        LocalDateTime instant,
        List<String> messages
) {
}
