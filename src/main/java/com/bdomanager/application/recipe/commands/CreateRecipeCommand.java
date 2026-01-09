package com.bdomanager.application.recipe.commands;

import java.util.List;

public record CreateRecipeCommand(String description,
                                  List<RecipeItemCommand> items) {
}
