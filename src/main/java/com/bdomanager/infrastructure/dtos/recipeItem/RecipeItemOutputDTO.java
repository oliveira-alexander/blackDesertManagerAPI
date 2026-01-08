package com.bdomanager.infrastructure.dtos.recipeItem;

import com.bdomanager.domain.item.model.ItemModel;

public record RecipeItemOutputDTO(ItemModel itemModel,
                                  int quantity) {
}
