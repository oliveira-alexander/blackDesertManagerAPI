package com.bdomanager.infrastructure.recipe.dtos;

import com.bdomanager.infrastructure.recipeItem.dtos.RecipeItemOutputDTO;

import java.util.List;

public record RecipeOutputDTO(Long id,
                              String description,
                              List<RecipeItemOutputDTO> items) {
}
