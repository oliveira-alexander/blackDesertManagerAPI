package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.application.recipe.useCases.GetAllRecipesUseCase;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.infrastructure.recipe.dtos.RecipeItemOutputDTO;
import com.bdomanager.infrastructure.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.infrastructure.recipe.entity.RecipeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllRecipesUseCaseImpl implements GetAllRecipesUseCase {
    private RecipeRepository repository;
    private ItemRepository itemRepository;

    public GetAllRecipesUseCaseImpl(RecipeRepository repository,
                                    ItemRepository itemRepository){
        this.repository = repository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Recipe> execute() {
       return repository.getAll();
    }
}
