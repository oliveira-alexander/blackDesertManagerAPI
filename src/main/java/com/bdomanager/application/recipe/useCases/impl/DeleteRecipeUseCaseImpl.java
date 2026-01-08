package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.useCases.DeleteRecipeUseCase;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteRecipeUseCaseImpl implements DeleteRecipeUseCase {

    private RecipeRepository repository;

    public DeleteRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public void execute(Long id) {
        repository.delete(id);
    }
}
