package com.bdomanager.application.services;

import com.bdomanager.infrastructure.dtos.recipe.RecipeInputDTO;
import com.bdomanager.infrastructure.dtos.recipe.RecipeOutputDTO;

import java.util.List;

public interface RecipeService {
    List<RecipeOutputDTO> getAll();
    RecipeOutputDTO getById(Long id);

    RecipeOutputDTO create (RecipeInputDTO newRecipe);
    RecipeOutputDTO update (RecipeInputDTO updatingRecipe);
    void delete (Long id);
}
