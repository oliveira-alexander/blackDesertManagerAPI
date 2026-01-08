package com.bdomanager.utils.mappers;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.domain.recipeItem.model.RecipeItemModel;
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

    public static RecipeModel createRecipeCommandToRecipeModel(CreateRecipeCommand command){
        RecipeModel recipeModel = new RecipeModel(command.description(), null);
        List<RecipeItemModel> recipeItemModels = new ArrayList<>();

        command.items().stream()
                .forEach(item -> {
                    recipeItemModels.add(
                            new RecipeItemModel(
                                    ItemMapper.itemEntityToItem(itemRepository.findById(item.itemId()).get()),
                                    item.quantity())
                    );
                });

        recipeModel.setItems(recipeItemModels);

        return recipeModel;
    }

    public static RecipeModel updateRecipeCommandToRecipeModel(UpdateRecipeCommand command){
        RecipeModel recipeModel = new RecipeModel(command.id(), command.description(), null);
        List<RecipeItemModel> recipeItemModels = new ArrayList<>();

        command.items().stream()
                .forEach(item -> {
                    recipeItemModels.add(
                            new RecipeItemModel(
                                    ItemMapper.itemEntityToItem(itemRepository.findById(item.itemId()).get()),
                                    item.quantity())
                    );
                });

        recipeModel.setItems(recipeItemModels);

        return recipeModel;
    }

    // Model domain -> Entity Infra
    public static RecipeEntity recipeModelToRecipeEntity(RecipeModel model){
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

    public static RecipeModel recipeEntityToRecipeModel(RecipeEntity entity){
        RecipeModel recipeModel = new RecipeModel(entity.getId(), entity.getDescription(), null);
        List<RecipeItemModel> recipeItemModels = new ArrayList<>();

        entity.getItems().stream().forEach(item -> {
            var itemModel = ItemMapper.itemEntityToItem(item.getItem());

            recipeItemModels.add(
                    new RecipeItemModel(itemModel, item.getQuantity())
            );
        });

        recipeModel.setItems(recipeItemModels);

        return recipeModel;
    }

    // Model Domain -> Output DTO

    public static RecipeOutputDTO recipeModelToRecipeDTO(RecipeModel model){
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
