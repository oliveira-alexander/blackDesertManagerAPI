package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.CreateRecipeUseCase;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.infrastructure.recipe.mapper.RecipeInfrastructureMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateRecipeUseCaseImpl implements CreateRecipeUseCase {

    private RecipeRepository repository;

    public CreateRecipeUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public RecipeOutputDTO execute(CreateRecipeCommand command) {
        return RecipeApplicationMapper.modelToDTO(repository.create(RecipeApplicationMapper.createCommandToModel(command)));
    }
}
