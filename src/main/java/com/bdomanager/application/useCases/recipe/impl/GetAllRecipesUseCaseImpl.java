package com.bdomanager.application.useCases.recipe.impl;

import com.bdomanager.application.useCases.recipe.GetAllRecipesUseCase;
import com.bdomanager.domain.recipe.model.Recipe;
import com.bdomanager.Application.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllRecipesUseCaseImpl implements GetAllRecipesUseCase {
    private RecipeRepository repository;

    public GetAllRecipesUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Recipe> execute() {
        return repository.getAll();
    }
}
