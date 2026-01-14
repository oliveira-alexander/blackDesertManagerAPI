package com.bdomanager.application.recipe.mapper;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.commands.RecipeItemCommand;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipe.dtos.RecipeItemOutputDTO;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.domain.recipeItem.RecipeItem;

import java.util.ArrayList;
import java.util.List;

public class RecipeApplicationMapper {

    // RecipeItems

        private static RecipeItem recipeItemCommandToModel(RecipeItemCommand command){
            return new RecipeItem(command.itemId(), command.quantity());
        }


    // Command -> Model

        public static Recipe createCommandToModel(CreateRecipeCommand command){
            List<RecipeItem> items = new ArrayList<>();

            command.items()
                    .forEach(item -> items.add(recipeItemCommandToModel(item)));

            return new Recipe(command.description(),
                                   items);
        }

        public static Recipe updateCommandToModel(UpdateRecipeCommand command){
            List<RecipeItem> items = new ArrayList<>();

            command.items()
                    .forEach(item -> items.add(recipeItemCommandToModel(item)));

            return new Recipe(command.id(),
                              command.description(),
                              items);
        }

    // Model -> DTO

        public static RecipeOutputDTO modelToDTO(Recipe model){
            List<RecipeItemOutputDTO> items = new ArrayList<>();

            model.getItems().forEach(item -> items.add(new RecipeItemOutputDTO(item.getIdItem(), item.getQuantity())));

            return new RecipeOutputDTO(model.getId(), model.getDescription(), items);
        }
}
