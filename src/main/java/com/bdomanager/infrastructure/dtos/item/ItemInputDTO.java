package com.bdomanager.infrastructure.dtos.item;

public record ItemInputDTO(Long id,
                           String description,
                           float marketPrice,
                           float productionCost) {
}
