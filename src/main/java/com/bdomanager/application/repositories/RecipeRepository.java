package com.bdomanager.Application.repositories;

import com.bdomanager.domain.recipe.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> getAll();
    Recipe getById(Long id);

    Recipe create(Recipe recipe);
    Recipe update(Recipe recipe);
    void delete(Long id);
}
