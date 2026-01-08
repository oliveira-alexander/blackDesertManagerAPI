package com.bdomanager.application.recipe.commands;

import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;
import com.bdomanager.application.recipeItem.commands.UpdateRecipeItemCommand;
import com.bdomanager.domain.recipeItem.model.RecipeItemModel;

import java.util.List;

public record UpdateRecipeCommand(Long id,
                                  String description,
                                  List<UpdateRecipeItemCommand> items) {
}
