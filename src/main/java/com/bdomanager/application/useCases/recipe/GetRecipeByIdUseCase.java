package com.bdomanager.application.useCases.recipe;

import com.bdomanager.domain.recipe.model.Recipe;

public interface GetRecipeByIdUseCase {
    Recipe execute(Long id);
}
