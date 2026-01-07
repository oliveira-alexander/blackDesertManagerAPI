package com.bdomanager.application.useCases.recipe;

import com.bdomanager.application.commands.recipe.CreateRecipeCommand;
import com.bdomanager.domain.models.Recipe;

public interface CreateRecipeUseCase {
    Recipe execute(CreateRecipeCommand command);
}
