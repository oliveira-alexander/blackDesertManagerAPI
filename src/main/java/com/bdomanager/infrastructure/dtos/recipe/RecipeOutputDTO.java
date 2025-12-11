package com.bdomanager.infrastructure.dtos.recipe;

import com.bdomanager.infrastructure.dtos.recipeItem.RecipeItemOutputDTO;

import java.util.List;
import java.util.Optional;

public record RecipeOutputDTO(Long id,
                              String description,
                              List<RecipeItemOutputDTO> items) {
}
