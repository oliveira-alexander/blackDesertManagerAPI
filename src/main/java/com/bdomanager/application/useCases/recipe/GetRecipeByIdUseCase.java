package com.bdomanager.application.useCases.recipe;

import com.bdomanager.domain.models.Recipe;

public interface GetRecipeByIdUseCase {
    Recipe execute(Long id);
}
