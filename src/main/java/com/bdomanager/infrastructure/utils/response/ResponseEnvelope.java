package com.bdomanager.infrastructure.utils.response;

import java.time.LocalDateTime;

public record ResponseEnvelope<T>(
        LocalDateTime instant,
        T data,
        String message
) {
}
