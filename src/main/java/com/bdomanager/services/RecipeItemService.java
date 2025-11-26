package com.bdomanager.services;

import com.bdomanager.dtos.recipeItem.RecipeItemInputDTO;
import com.bdomanager.dtos.recipeItem.RecipeItemOutputDTO;

import java.util.List;

public interface RecipeItemService {
    void addItem(Long recipeId, RecipeItemInputDTO recipeItem);
    void updateItems(Long recipeId, List<RecipeItemInputDTO> recipeItems);
    List<RecipeItemOutputDTO> getRecipeItems(Long recipeId);
}
