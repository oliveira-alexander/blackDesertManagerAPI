package com.bdomanager.application.recipeItem.adapters.repository;

import com.bdomanager.domain.recipeItem.model.RecipeItemModel;

public interface RecipeItemRepository {
    RecipeItemModel addRecipeItem(RecipeItemModel model);
    RecipeItemModel updateRecipeItem(RecipeItemModel model);
    void deleteRecipeItem(Long idRecipe, RecipeItemModel model);
}
