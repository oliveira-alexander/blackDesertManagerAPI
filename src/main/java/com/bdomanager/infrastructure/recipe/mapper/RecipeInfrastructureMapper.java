package com.bdomanager.Infrastructure.recipe.mapper;

import com.bdomanager.Infrastructure.item.mapper.ItemInfrastructureMapper;
import com.bdomanager.Infrastructure.recipe.dtos.RecipeInputDTO;
import com.bdomanager.Infrastructure.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.Infrastructure.recipe.entity.RecipeEntity;
import com.bdomanager.Infrastructure.recipeItem.dtos.RecipeItemOutputDTO;
import com.bdomanager.Infrastructure.recipeItem.entity.RecipeItemEntity;
import com.bdomanager.Infrastructure.recipeItem.mapper.RecipeItemInfrastructureMapper;
import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;
import com.bdomanager.application.recipeItem.commands.UpdateRecipeItemCommand;
import com.bdomanager.domain.item.model.ItemModel;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.domain.recipeItem.model.RecipeItemModel;

import java.util.ArrayList;
import java.util.List;

public class RecipeInfrastructureMapper {

    // DTO -> Command

        public static CreateRecipeCommand dtoToCreateCommand(RecipeInputDTO dto){
            List<CreateRecipeItemCommand> itemsCommand =
                dto.items()
                   .stream()
                   .map(RecipeItemInfrastructureMapper::dtoToCreateCommand)
                   .toList();

            return new CreateRecipeCommand(dto.description(), itemsCommand);
        }

        public static UpdateRecipeCommand dtoToUpdateCommand(RecipeInputDTO dto){
            List<UpdateRecipeItemCommand> itemsCommand =
                    dto.items()
                            .stream()
                            .map(RecipeItemInfrastructureMapper::dtoToUpdateCommand)
                            .toList();

            return new UpdateRecipeCommand(dto.id(), dto.description(), itemsCommand);
        }

        // Entity -> Model

            public static RecipeModel entityToModel(RecipeEntity entity){
                List<RecipeItemModel> itemsModel = new ArrayList<>();

                entity.getItems().forEach(item -> {
                    itemsModel.add(new RecipeItemModel(item.getId(), item.getId(), item.getQuantity()));
                });

                return new RecipeModel(entity.getId(), entity.getDescription(), itemsModel);
            }

        // Model -> DTO

            public static RecipeOutputDTO modelToDTO(RecipeModel model){
                List<RecipeItemOutputDTO> items = model.getItems().stream().map(RecipeItemInfrastructureMapper::modelToDTO).toList();

                return new RecipeOutputDTO(model.getId(), model.getDescription(), items);
            }
}

