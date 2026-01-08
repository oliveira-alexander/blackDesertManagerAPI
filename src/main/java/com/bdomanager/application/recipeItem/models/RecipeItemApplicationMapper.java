package com.bdomanager.application.recipeItem.models;

import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;
import com.bdomanager.application.recipeItem.commands.UpdateRecipeItemCommand;
import com.bdomanager.domain.recipeItem.RecipeItem;

public class RecipeItemApplicationMapper {

    // Command -> Model

        public static RecipeItem createCommandToModel(CreateRecipeItemCommand command){
            return new RecipeItem(command.idItem(), command.quantity());
        }

        public static RecipeItem updateCommandToModel(UpdateRecipeItemCommand command){
            return new RecipeItem(command.id(), command.idItem(), command.quantity());
        }
}
