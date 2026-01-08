package com.bdomanager.infrastructure.dtos.recipeItem;

import com.bdomanager.domain.item.model.Item;

public record RecipeItemOutputDTO(Item item,
                                  int quantity) {
}
