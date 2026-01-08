package com.bdomanager.infrastructure.recipe.mapper;

import com.bdomanager.infrastructure.recipe.dtos.RecipeInputDTO;
import com.bdomanager.infrastructure.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.infrastructure.recipe.entity.RecipeEntity;
import com.bdomanager.infrastructure.recipeItem.dtos.RecipeItemOutputDTO;
import com.bdomanager.infrastructure.recipeItem.mapper.RecipeItemInfrastructureMapper;
import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;
import com.bdomanager.application.recipeItem.commands.UpdateRecipeItemCommand;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.domain.recipeItem.RecipeItem;

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

            public static Recipe entityToModel(RecipeEntity entity){
                List<RecipeItem> itemsModel = new ArrayList<>();

                entity.getItems().forEach(item -> {
                    itemsModel.add(new RecipeItem(item.getId(), item.getId(), item.getQuantity()));
                });

                return new Recipe(entity.getId(), entity.getDescription(), itemsModel);
            }

        // Model -> DTO

            public static RecipeOutputDTO modelToDTO(Recipe model){
                List<RecipeItemOutputDTO> items = model.getItems().stream().map(RecipeItemInfrastructureMapper::modelToDTO).toList();

                return new RecipeOutputDTO(model.getId(), model.getDescription(), items);
            }
}

