package com.bdomanager.application.recipeItem.adapters.repository;

import com.bdomanager.domain.recipeItem.RecipeItem;

public interface RecipeItemRepository {
    RecipeItem addRecipeItem(RecipeItem model);
    RecipeItem updateRecipeItem(RecipeItem model);
    void deleteRecipeItem(Long idRecipe, RecipeItem model);
}
