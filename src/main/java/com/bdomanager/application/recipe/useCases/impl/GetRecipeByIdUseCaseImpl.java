package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.useCases.GetRecipeByIdUseCase;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class GetRecipeByIdUseCaseImpl implements GetRecipeByIdUseCase {

    private final RecipeRepository repository;

    public GetRecipeByIdUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public RecipeModel execute(Long id) {
        return repository.getById(id);
    }
}
