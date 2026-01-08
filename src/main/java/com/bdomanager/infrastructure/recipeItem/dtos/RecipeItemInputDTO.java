package com.bdomanager.infrastructure.recipeItem.dtos;

import jakarta.annotation.Nullable;

public record RecipeItemInputDTO(@Nullable
                                 Long id,
                                 Long itemId,
                                 int quantity) {
}
