package com.bdomanager.utils.mappers;

import com.bdomanager.application.commands.recipe.CreateRecipeCommand;
import com.bdomanager.application.commands.recipe.UpdateRecipeCommand;
import com.bdomanager.application.commands.recipeItem.CreateRecipeItemCommand;
import com.bdomanager.domain.models.Item;
import com.bdomanager.domain.models.Recipe;
import com.bdomanager.domain.models.RecipeItem;
import com.bdomanager.infrastructure.adapt.repositories.ItemJPARepository;
import com.bdomanager.infrastructure.dtos.recipe.RecipeInputDTO;
import com.bdomanager.infrastructure.dtos.recipe.RecipeOutputDTO;
import com.bdomanager.infrastructure.dtos.recipeItem.RecipeItemOutputDTO;
import com.bdomanager.infrastructure.entities.RecipeEntity;
import com.bdomanager.infrastructure.entities.RecipeItemEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeMapper {

    private static ItemJPARepository itemRepository;

    public RecipeMapper(ItemJPARepository itemRepository){
        this.itemRepository = itemRepository;
    }

    // Input DTO -> Command

    public static CreateRecipeCommand inputDTOToCreateCommand(RecipeInputDTO recipeDTO){
        List<CreateRecipeItemCommand> items = new ArrayList<>();
        recipeDTO.items().stream()
                         .forEach( item -> {
            items.add(new CreateRecipeItemCommand(item.itemId(), item.quantity()));
        });

        return new CreateRecipeCommand(recipeDTO.description(), items);
    }

    public static UpdateRecipeCommand inputDTOToUpdateCommand(RecipeInputDTO recipeDTO){
        List<CreateRecipeItemCommand> items = new ArrayList<>();
        recipeDTO.items().stream()
                .forEach( item -> {
                    items.add(new CreateRecipeItemCommand(item.itemId(), item.quantity()));
                });

        return new UpdateRecipeCommand(recipeDTO.id(), recipeDTO.description(), items);
    }

    // Command -> Model Domain

    public static Recipe createRecipeCommandToRecipeModel(CreateRecipeCommand command){
        Recipe recipe = new Recipe(command.description(), null);
        List<RecipeItem> recipeItems = new ArrayList<>();

        command.items().stream()
                .forEach(item -> {
                    recipeItems.add(
                            new RecipeItem(
                                    ItemMapper.itemEntityToItem(itemRepository.findById(item.itemId()).get()),
                                    item.quantity())
                    );
                });

        recipe.setItems(recipeItems);

        return recipe;
    }

    public static Recipe updateRecipeCommandToRecipeModel(UpdateRecipeCommand command){
        Recipe recipe = new Recipe(command.id(), command.description(), null);
        List<RecipeItem> recipeItems = new ArrayList<>();

        command.items().stream()
                .forEach(item -> {
                    recipeItems.add(
                            new RecipeItem(
                                    ItemMapper.itemEntityToItem(itemRepository.findById(item.itemId()).get()),
                                    item.quantity())
                    );
                });

        recipe.setItems(recipeItems);

        return recipe;
    }

    // Model domain -> Entity Infra
    public static RecipeEntity recipeModelToRecipeEntity(Recipe model){
        List<RecipeItemEntity> recipeItemsEntity = new ArrayList<>();

        RecipeEntity recipe = new RecipeEntity(model.getId(), model.getDescription());
        model.getItems().stream()
                .forEach(item -> {
                    recipeItemsEntity.add(
                            new RecipeItemEntity(recipe,
                                                 itemRepository.findById(item.getItem().getId()).get(),
                                                 item.getQuantity()
                            )
                    );
                });

        recipe.setItems(recipeItemsEntity);
        return recipe;
    }

    // Entity Infra -> Model Domain

    public static Recipe recipeEntityToRecipeModel(RecipeEntity entity){
        Recipe recipe = new Recipe(entity.getId(), entity.getDescription(), null);
        List<RecipeItem> recipeItems = new ArrayList<>();

        entity.getItems().stream().forEach(item -> {
            var itemModel = ItemMapper.itemEntityToItem(item.getItem());

            recipeItems.add(
                    new RecipeItem(itemModel, item.getQuantity())
            );
        });

        recipe.setItems(recipeItems);

        return recipe;
    }

    // Model Domain -> Output DTO

    public static RecipeOutputDTO recipeModelToRecipeDTO(Recipe model){
        List<RecipeItemOutputDTO> recipeItems = new ArrayList<>();

        model.getItems().stream()
                .forEach(item -> {
                    recipeItems.add(
                            new RecipeItemOutputDTO(item.getItem(), item.getQuantity())
                    );
                });

        return new RecipeOutputDTO(model.getId(), model.getDescription(), recipeItems);
    }
}
