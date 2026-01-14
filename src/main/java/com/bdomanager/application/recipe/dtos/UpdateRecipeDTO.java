package com.bdomanager.application.recipe.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UpdateRecipeDTO(
        @Nullable
        Long id,

        @NotBlank(message = "Informe a descrição da receita!")
        @Size(min = 3, message = "A descrição deve ter pelo menos 3 caracteres!")
        String description,

        @NotNull(message = "A lista de itens não pode estar em branco!")
        @Size(min        = 3, message = "A quantidade de itens deve conter pelo menos 3 itens!")
        List<UpdateRecipeItemDTO> items) {
}
