package com.bdomanager.application.recipe.dtos;

import java.util.List;

public record RecipeOutputDTO(
      Long id,
      String description,
      List<RecipeItemOutputDTO> items
){}
