package com.bdomanager.application.recipe.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RecipeItemInputDTO(
        @Nullable
        Long id,

        @NotNull(message = "Informe o ID do item!")
        @Min(value = 1, message = "Informe um ID de item válido!")
        Long itemId,

        @NotNull(message = "Informe a quantidade do item!")
        @Min(value = 1, message = "Informe uma quantidade positiva válida para o item!")
        int quantity) {
}
