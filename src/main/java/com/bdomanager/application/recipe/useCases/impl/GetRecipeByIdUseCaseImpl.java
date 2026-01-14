package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.GetRecipeByIdUseCase;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class GetRecipeByIdUseCaseImpl implements GetRecipeByIdUseCase {

    private final RecipeRepository repository;

    public GetRecipeByIdUseCaseImpl(RecipeRepository repository){
        this.repository = repository;
    }

    @Override
    public RecipeOutputDTO execute(Long id) {
        return RecipeApplicationMapper.modelToDTO(repository.getById(id));
    }
}
