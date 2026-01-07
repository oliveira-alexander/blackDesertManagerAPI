package com.bdomanager.application.commands.recipe;

import com.bdomanager.application.commands.recipeItem.CreateRecipeItemCommand;

import java.util.List;

public record CreateRecipeCommand(String description,
                                  List<CreateRecipeItemCommand> items) {
}
