package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.useCases.GetAllRecipesUseCase;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllRecipesUseCaseImpl implements GetAllRecipesUseCase {
    private RecipeRepository repository;

    public GetAllRecipesUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public List<RecipeModel> execute() {
        return repository.getAll();
    }
}
