package com.bdomanager.application.recipe.useCases.impl;

import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.dtos.RecipeItemItemDTO;
import com.bdomanager.application.recipe.dtos.RecipeItemOutputDTO;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.application.recipe.mapper.RecipeApplicationMapper;
import com.bdomanager.application.recipe.useCases.CreateRecipeUseCase;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.domain.item.Item;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.infrastructure.item.adapters.repository.ItemJPARepository;
import com.bdomanager.infrastructure.item.entity.ItemEntity;
import com.bdomanager.infrastructure.recipe.mapper.RecipeInfrastructureMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateRecipeUseCaseImpl implements CreateRecipeUseCase {

    private ItemRepository itemRepository;
    private RecipeRepository repository;

    public CreateRecipeUseCaseImpl(RecipeRepository repository,
                                   ItemRepository itemRepository){
        this.repository = repository;
        this.itemRepository = itemRepository;
    }

    @Override
    public RecipeOutputDTO execute(CreateRecipeCommand command) {
        Recipe model = repository.create(RecipeApplicationMapper.createCommandToModel(command));

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
