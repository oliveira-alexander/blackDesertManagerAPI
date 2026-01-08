package com.bdomanager.application.recipeItem.commands;

public record CreateRecipeItemCommand(Long idItem,
                                      int quantity) {
}
