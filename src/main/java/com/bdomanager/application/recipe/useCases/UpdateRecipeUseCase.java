package com.bdomanager.application.recipe.useCases;

import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.domain.recipe.model.RecipeModel;

public interface UpdateRecipeUseCase {
    RecipeModel execute(UpdateRecipeCommand command);
}
