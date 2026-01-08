package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.CreateRecipeUseCase;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateRecipeUseCaseImpl implements CreateRecipeUseCase {

    private RecipeRepository repository;

    public CreateRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public Recipe execute(CreateRecipeCommand command) {
        return repository.create(RecipeApplicationMapper.createCommandToModel(command));
    }
}
