package com.bdomanager.application.item.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ItemInputDTO(
        @Nullable
        Long id,

        @NotBlank(message = "Informe a descrição do item!")
        @Size(min = 3, message = "A descrição deve ter pelo menos 3 caracteres!")
        String description,

        @Min(value = 0, message = "Informe um valor positivo para o valor de mercado!")
        float marketPrice,

        @Min(value = 0, message = "Informe um valor positivo para o custo de produção!")
        float productionCost) {
}
