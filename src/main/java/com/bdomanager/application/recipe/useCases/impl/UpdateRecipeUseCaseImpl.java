package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipe.dtos.RecipeItemItemDTO;
import com.bdomanager.application.recipe.dtos.RecipeItemOutputDTO;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.UpdateRecipeUseCase;
import com.bdomanager.domain.item.Item;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateRecipeUseCaseImpl implements UpdateRecipeUseCase {

    private final ItemRepository itemRepository;
    private final RecipeRepository repository;

    public UpdateRecipeUseCaseImpl(RecipeRepository repository, ItemRepository itemRepository){
        this.repository = repository;
        this.itemRepository = itemRepository;
    }

    @Override
    public RecipeOutputDTO execute(UpdateRecipeCommand command) {
        Recipe model = repository.getById(command.id());

        List<RecipeItemOutputDTO> outputItems = new ArrayList<>();

        model.getItems().forEach(item -> {
            Item itemModel = itemRepository.getById(item.getIdItem());
            RecipeItemItemDTO recipeItemItem = new RecipeItemItemDTO(itemModel.getId(),
                    itemModel.getDescription(),
                    itemModel.getMarketPrice(),
                    itemModel.getProductionCost());

            RecipeItemOutputDTO output = new RecipeItemOutputDTO(recipeItemItem, item.getQuantity());

            outputItems.add(output);
        });

        return new RecipeOutputDTO(model.getId(), model.getDescription(), outputItems);
    }
}
