package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.useCases.CreateRecipeUseCase;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.utils.mappers.RecipeMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateRecipeUseCaseImpl implements CreateRecipeUseCase {

    private RecipeRepository repository;

    public CreateRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public RecipeModel execute(CreateRecipeCommand command) {
        return repository.create(
                RecipeMapper.createRecipeCommandToRecipeModel(command)
        );
    }
}
