package com.bdomanager.application.useCases.recipe;

import com.bdomanager.application.commands.recipe.UpdateRecipeCommand;
import com.bdomanager.domain.models.Recipe;

public interface UpdateRecipeUseCase {
    Recipe execute(UpdateRecipeCommand command);
}
