package com.bdomanager.dtos.recipe;

import com.bdomanager.dtos.recipeItem.RecipeItemInputDTO;

import java.util.List;
import java.util.Optional;

public record RecipeInputDTO(Optional<Long> id,
                             String description,
                             Optional<List<RecipeItemInputDTO>> items) {
}
