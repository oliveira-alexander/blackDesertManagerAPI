package com.bdomanager.Infrastructure.recipe.dtos;

import com.bdomanager.Infrastructure.recipeItem.dtos.RecipeItemInputDTO;

import java.util.List;

public record RecipeInputDTO(Long id,
                             String description,
                             List<RecipeItemInputDTO> items) {
}
