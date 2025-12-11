package com.bdomanager.application.useCases.recipe;

import com.bdomanager.domain.models.Recipe;

import java.util.List;

public interface GetAllRecipesUseCase {
    List<Recipe> execute();
}
