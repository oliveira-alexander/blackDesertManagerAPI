package com.bdomanager.application.useCases.recipe;

import com.bdomanager.domain.recipe.model.Recipe;

import java.util.List;

public interface GetAllRecipesUseCase {
    List<Recipe> execute();
}
