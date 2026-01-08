package com.bdomanager.application.recipeItem.commands;

public record CreateRecipeItemCommand(Long itemId,
                                      int quantity) {
}
