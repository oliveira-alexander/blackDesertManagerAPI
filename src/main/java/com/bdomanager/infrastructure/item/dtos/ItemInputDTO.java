package com.bdomanager.infrastructure.item.dtos;

public record ItemInputDTO(Long id,
                           String description,
                           float marketPrice,
                           float productionCost) {
}
