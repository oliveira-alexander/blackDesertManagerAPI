package com.bdomanager.application.useCases.recipe.impl;

import com.bdomanager.application.useCases.recipe.DeleteRecipeUseCase;
import com.bdomanager.domain.repositories.RecipeRepository;
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
