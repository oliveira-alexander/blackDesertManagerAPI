package com.bdomanager.infrastructure.recipe.mapper;

import com.bdomanager.application.recipe.commands.RecipeItemCommand;
import com.bdomanager.application.recipe.dtos.CreateRecipeDTO;
import com.bdomanager.application.recipe.dtos.UpdateRecipeDTO;
import com.bdomanager.application.recipe.dtos.RecipeItemOutputDTO;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.infrastructure.recipe.entity.RecipeEntity;
import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.domain.recipeItem.RecipeItem;

import java.util.ArrayList;
import java.util.List;

public class RecipeInfrastructureMapper {

    // DTO -> Command

        public static CreateRecipeCommand dtoToCreateCommand(CreateRecipeDTO dto){
            List<RecipeItemCommand> items = new ArrayList<>();

            dto.items().forEach(item -> items.add(new RecipeItemCommand(item.itemId(), item.quantity())));

            return new CreateRecipeCommand(dto.description(), items);
        }

        public static UpdateRecipeCommand dtoToUpdateCommand(UpdateRecipeDTO dto){
            List<RecipeItemCommand> items = new ArrayList<>();

            dto.items().forEach(item -> items.add(new RecipeItemCommand(item.itemId(), item.quantity())));

            return new UpdateRecipeCommand(dto.id(), dto.description(), items);
        }

        // Entity -> Model

            public static Recipe entityToModel(RecipeEntity entity){
                List<RecipeItem> items = new ArrayList<>();

                entity.getItems().forEach(item -> items.add(new RecipeItem(item.getItemId(), item.getQuantity())));

                return new Recipe(entity.getId(), entity.getDescription(), items);
            }


}

