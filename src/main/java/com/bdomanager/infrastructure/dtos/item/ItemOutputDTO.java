package com.bdomanager.infrastructure.dtos.item;

public record ItemOutputDTO(Long id,
                            String description,
                            float marketPrice,
                            float productionCost) {
}
