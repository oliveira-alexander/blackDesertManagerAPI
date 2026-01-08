package com.bdomanager.application.recipe.useCases;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.domain.recipe.model.RecipeModel;

public interface CreateRecipeUseCase {
    RecipeModel execute(CreateRecipeCommand command);
}
