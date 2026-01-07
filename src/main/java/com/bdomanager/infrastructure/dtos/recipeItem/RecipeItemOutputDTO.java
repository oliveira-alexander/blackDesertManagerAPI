package com.bdomanager.infrastructure.dtos.recipeItem;

import com.bdomanager.domain.models.Item;

public record RecipeItemOutputDTO(Item item,
                                  int quantity) {
}
