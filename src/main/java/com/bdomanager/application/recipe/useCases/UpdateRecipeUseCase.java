package com.bdomanager.application.recipe.useCases;

import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.domain.recipe.Recipe;

public interface UpdateRecipeUseCase {
    RecipeOutputDTO execute(UpdateRecipeCommand command);
}
