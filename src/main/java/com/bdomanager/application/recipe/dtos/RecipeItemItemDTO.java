package com.bdomanager.application.recipe.dtos;

public record RecipeItemItemDTO(
        Long id,
        String description,
        float marketPrice,
        float productionCost) {
}
