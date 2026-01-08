package com.bdomanager.application.recipe.commands;

import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;

import java.util.List;

public record CreateRecipeCommand(String description,
                                  List<CreateRecipeItemCommand> items) {
}
