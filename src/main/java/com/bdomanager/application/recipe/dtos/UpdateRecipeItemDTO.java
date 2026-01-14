package com.bdomanager.application.recipe.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateRecipeItemDTO(
        @NotNull (message = "Informe o id do item da receita a ser alterado!")
        Long id,

        @NotNull(message = "Informe o ID do item!")
        @Min(value = 1, message = "Informe um ID de item válido!")
        Long itemId,

        @NotNull(message = "Informe a quantidade do item!")
        @Min(value = 1, message = "Informe uma quantidade positiva válida para o item!")
        int quantity) {
}
