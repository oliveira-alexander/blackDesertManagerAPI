package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipe.useCases.UpdateRecipeUseCase;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.utils.mappers.RecipeMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateRecipeUseCaseImpl implements UpdateRecipeUseCase {

    private final RecipeRepository repository;

    public UpdateRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public RecipeModel execute(UpdateRecipeCommand command) {
        return repository.update(RecipeMapper.updateRecipeCommandToRecipeModel(command));
    }
}
