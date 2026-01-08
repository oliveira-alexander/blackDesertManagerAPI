package com.bdomanager.Infrastructure.item.dtos;

public record ItemInputDTO(Long id,
                           String description,
                           float marketPrice,
                           float productionCost) {
}
