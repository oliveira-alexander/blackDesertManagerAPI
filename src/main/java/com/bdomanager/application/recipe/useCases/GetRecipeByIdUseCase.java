package com.bdomanager.application.recipe.useCases;

import com.bdomanager.domain.recipe.Recipe;

public interface GetRecipeByIdUseCase {
    Recipe execute(Long id);
}
