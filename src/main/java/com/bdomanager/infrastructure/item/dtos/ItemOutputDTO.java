package com.bdomanager.infrastructure.item.dtos;

public record ItemOutputDTO(Long id,
                            String description,
                            float marketPrice,
                            float productionCost) {
}
