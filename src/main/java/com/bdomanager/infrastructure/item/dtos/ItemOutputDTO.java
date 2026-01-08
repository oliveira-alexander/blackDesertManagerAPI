package com.bdomanager.Infrastructure.item.dtos;

public record ItemOutputDTO(Long id,
                            String description,
                            float marketPrice,
                            float productionCost) {
}
