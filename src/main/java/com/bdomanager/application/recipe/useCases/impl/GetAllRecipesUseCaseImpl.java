package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.GetAllRecipesUseCase;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

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
    public List<RecipeOutputDTO> execute() {
       return repository.getAll().stream()
               .map(RecipeApplicationMapper::modelToDTO)
               .toList();
    }
}
