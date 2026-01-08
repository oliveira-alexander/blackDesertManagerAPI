package com.bdomanager.application.recipe.useCases;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.domain.recipe.Recipe;

public interface CreateRecipeUseCase {
    Recipe execute(CreateRecipeCommand command);
}
