package com.bdomanager.application.recipe.commands;

import java.util.List;

public record UpdateRecipeCommand(Long id,
                                  String description,
                                  List<RecipeItemCommand> items) {
}
