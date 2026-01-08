package com.bdomanager.application.recipe.useCases;

import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.domain.recipe.Recipe;

public interface UpdateRecipeUseCase {
    Recipe execute(UpdateRecipeCommand command);
}
