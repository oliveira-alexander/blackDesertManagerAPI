package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.UpdateRecipeUseCase;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateRecipeUseCaseImpl implements UpdateRecipeUseCase {

    private final RecipeRepository repository;

    public UpdateRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public Recipe execute(UpdateRecipeCommand command) {
        return repository.update(RecipeApplicationMapper.updateCommandToModel(command));
    }
}
