package com.bdomanager.dtos.item;

public record ItemInputDTO(Long id,
                           String description,
                           float marketPrice,
                           float productionCost) {
}
