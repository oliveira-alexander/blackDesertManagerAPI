package com.bdomanager.application.useCases.recipe.impl;

import com.bdomanager.application.useCases.recipe.GetAllRecipesUseCase;
import com.bdomanager.domain.models.Recipe;
import com.bdomanager.domain.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
