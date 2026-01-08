package com.bdomanager.application.recipeItem.commands;

public record UpdateRecipeItemCommand(Long id,
                                      Long itemId,
                                      int quantity) {
}
