package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.application.recipe.dtos.RecipeItemItemDTO;
import com.bdomanager.application.recipe.dtos.RecipeItemOutputDTO;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.GetAllRecipesUseCase;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.domain.item.Item;
import com.bdomanager.domain.recipe.Recipe;
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
    public List<RecipeOutputDTO> execute() {
       List<Recipe> recipesModel = repository.getAll();
       List<RecipeOutputDTO> recipesOutput = new ArrayList<>();

       recipesModel.forEach(recipe -> {
           List<RecipeItemOutputDTO> outputItems = new ArrayList<>();

           recipe.getItems().forEach(item -> {
               Item itemModel = itemRepository.getById(item.getIdItem());
               RecipeItemItemDTO recipeItemItem = new RecipeItemItemDTO(itemModel.getId(),
                       itemModel.getDescription(),
                       itemModel.getMarketPrice(),
                       itemModel.getProductionCost());

               RecipeItemOutputDTO output = new RecipeItemOutputDTO(recipeItemItem, item.getQuantity());

               outputItems.add(output);
           });

           recipesOutput.add(new RecipeOutputDTO(recipe.getId(), recipe.getDescription(), outputItems));

       });

       return recipesOutput;
    }
}
