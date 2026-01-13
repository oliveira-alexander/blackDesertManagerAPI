package com.bdomanager.application.item.dtos;

public record ItemOutputDTO(
        Long id,
        String description,
        float marketPrice,
        float productionCost) {
}
