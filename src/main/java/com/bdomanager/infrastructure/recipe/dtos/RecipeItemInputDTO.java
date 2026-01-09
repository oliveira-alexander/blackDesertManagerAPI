package com.bdomanager.infrastructure.recipe.dtos;

import jakarta.annotation.Nullable;

public record RecipeItemInputDTO(@Nullable
                                 Long id,
                                 Long itemId,
                                 int quantity) {
}
