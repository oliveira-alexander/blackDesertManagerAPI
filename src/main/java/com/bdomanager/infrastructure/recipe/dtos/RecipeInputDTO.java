package com.bdomanager.infrastructure.recipe.dtos;

import com.bdomanager.infrastructure.recipeItem.dtos.RecipeItemInputDTO;

import java.util.List;

public record RecipeInputDTO(Long id,
                             String description,
                             List<RecipeItemInputDTO> items) {
}
