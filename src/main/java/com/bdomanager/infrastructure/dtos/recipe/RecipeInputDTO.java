package com.bdomanager.infrastructure.dtos.recipe;

import com.bdomanager.infrastructure.dtos.recipeItem.RecipeItemInputDTO;

import java.util.List;
import java.util.Optional;

public record RecipeInputDTO(Long id,
                             String description,
                             List<RecipeItemInputDTO> items) {
}
