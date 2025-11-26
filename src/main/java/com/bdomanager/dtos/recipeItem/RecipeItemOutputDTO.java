package com.bdomanager.dtos.recipeItem;

import com.bdomanager.entities.Item;

public record RecipeItemOutputDTO(Item item,
                                  int quantity) {
}
