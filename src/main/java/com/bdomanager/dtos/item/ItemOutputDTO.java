package com.bdomanager.dtos.item;

public record ItemOutputDTO(Long id,
                            String description,
                            float marketPrice,
                            float productionCost) {
}
