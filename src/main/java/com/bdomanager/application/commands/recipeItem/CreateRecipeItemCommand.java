package com.bdomanager.application.commands.recipeItem;

public record CreateRecipeItemCommand(Long itemId,
                                      int quantity) {
}
