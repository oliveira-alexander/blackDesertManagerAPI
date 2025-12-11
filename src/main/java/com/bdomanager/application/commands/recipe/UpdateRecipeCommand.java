package com.bdomanager.application.commands.recipe;

import com.bdomanager.application.commands.recipeItem.CreateRecipeItemCommand;

import java.util.List;

public record UpdateRecipeCommand(Long id,
                                  String description,
                                  List<CreateRecipeItemCommand> items) {
}
