package com.bdomanager.application.useCases.recipe.impl;

import com.bdomanager.application.commands.recipe.UpdateRecipeCommand;
import com.bdomanager.application.useCases.recipe.UpdateRecipeUseCase;
import com.bdomanager.domain.recipe.model.Recipe;
import com.bdomanager.Application.repositories.RecipeRepository;
import com.bdomanager.utils.mappers.RecipeMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateRecipeUseCaseImpl implements UpdateRecipeUseCase {

    private final RecipeRepository repository;

    public UpdateRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public Recipe execute(UpdateRecipeCommand command) {
        return repository.update(RecipeMapper.updateRecipeCommandToRecipeModel(command));
    }
}
