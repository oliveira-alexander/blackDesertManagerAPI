package com.bdomanager.application.recipe.useCases;

import com.bdomanager.domain.recipe.Recipe;

import java.util.List;

public interface GetAllRecipesUseCase {
    List<Recipe> execute();
}
