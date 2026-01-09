package com.bdomanager.infrastructure.recipe.dtos;

import java.util.List;

public record RecipeInputDTO(Long id,
                             String description,
                             List<RecipeItemInputDTO> items) {
}
