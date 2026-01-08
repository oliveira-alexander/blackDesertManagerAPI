package com.bdomanager.application.recipe.commands;

import com.bdomanager.application.recipeItem.commands.UpdateRecipeItemCommand;

import java.util.List;

public record UpdateRecipeCommand(Long id,
                                  String description,
                                  List<UpdateRecipeItemCommand> items) {
}
