package com.bdomanager.application.useCases.recipe.impl;

import com.bdomanager.application.useCases.recipe.GetRecipeByIdUseCase;
import com.bdomanager.domain.recipe.model.Recipe;
import com.bdomanager.Application.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class GetRecipeByIdUseCaseImpl implements GetRecipeByIdUseCase {

    private final RecipeRepository repository;

    public GetRecipeByIdUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public Recipe execute(Long id) {
        return repository.getById(id);
    }
}
