package com.bdomanager.application.useCases.recipe;

import com.bdomanager.application.commands.recipe.CreateRecipeCommand;
import com.bdomanager.domain.recipe.model.Recipe;

public interface CreateRecipeUseCase {
    Recipe execute(CreateRecipeCommand command);
}
