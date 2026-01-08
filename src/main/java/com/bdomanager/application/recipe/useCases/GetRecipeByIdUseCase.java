package com.bdomanager.application.recipe.useCases;

import com.bdomanager.domain.recipe.model.RecipeModel;

public interface GetRecipeByIdUseCase {
    RecipeModel execute(Long id);
}
