package com.bdomanager.application.recipe.useCases;

import com.bdomanager.domain.recipe.model.RecipeModel;

import java.util.List;

public interface GetAllRecipesUseCase {
    List<RecipeModel> execute();
}
