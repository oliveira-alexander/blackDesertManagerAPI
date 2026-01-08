package com.bdomanager.application.recipe.adapters.repository;

import com.bdomanager.domain.recipe.model.RecipeModel;

import java.util.List;

public interface RecipeRepository {
    List<RecipeModel> getAll();
    RecipeModel getById(Long id);

    RecipeModel create(RecipeModel recipeModel);
    RecipeModel update(RecipeModel recipeModel);
    void delete(Long id);
}
