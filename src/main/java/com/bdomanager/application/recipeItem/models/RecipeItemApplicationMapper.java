package com.bdomanager.application.recipeItem.models;

import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;
import com.bdomanager.application.recipeItem.commands.UpdateRecipeItemCommand;
import com.bdomanager.domain.recipeItem.model.RecipeItemModel;

public class RecipeItemApplicationMapper {

    // Command -> Model

        public static RecipeItemModel createCommandToModel(CreateRecipeItemCommand command){
            return new RecipeItemModel(command.idItem(), command.quantity());
        }

        public static RecipeItemModel updateCommandToModel(UpdateRecipeItemCommand command){
            return new RecipeItemModel(command.id(), command.idItem(), command.quantity());
        }
}
