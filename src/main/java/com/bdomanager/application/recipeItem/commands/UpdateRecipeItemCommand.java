package com.bdomanager.application.recipeItem.commands;

public record UpdateRecipeItemCommand(Long id,
                                      Long idItem,
                                      int quantity) {
}
