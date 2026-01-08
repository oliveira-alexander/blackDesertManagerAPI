package com.bdomanager.application.useCases.recipe.impl;

import com.bdomanager.application.commands.recipe.CreateRecipeCommand;
import com.bdomanager.application.useCases.recipe.CreateRecipeUseCase;
import com.bdomanager.domain.recipe.model.Recipe;
import com.bdomanager.Application.repositories.RecipeRepository;
import com.bdomanager.utils.mappers.RecipeMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateRecipeUseCaseImpl implements CreateRecipeUseCase {

    private RecipeRepository repository;

    public CreateRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public Recipe execute(CreateRecipeCommand command) {
        return repository.create(
                RecipeMapper.createRecipeCommandToRecipeModel(command)
        );
    }
}
