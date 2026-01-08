package com.bdomanager.Infrastructure.recipeItem.dtos;

import com.bdomanager.domain.item.model.ItemModel;

public record RecipeItemOutputDTO(Long idItem,
                                  int quantity) {
}
