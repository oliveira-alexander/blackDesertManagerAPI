package com.bdomanager.application.recipe.useCases;

import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.domain.recipe.Recipe;

public interface GetRecipeByIdUseCase {
    RecipeOutputDTO execute(Long id);
}
