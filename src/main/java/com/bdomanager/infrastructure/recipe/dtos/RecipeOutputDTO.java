package com.bdomanager.Infrastructure.recipe.dtos;

import com.bdomanager.Infrastructure.recipeItem.dtos.RecipeItemOutputDTO;

import java.util.List;

public record RecipeOutputDTO(Long id,
                              String description,
                              List<RecipeItemOutputDTO> items) {
}
