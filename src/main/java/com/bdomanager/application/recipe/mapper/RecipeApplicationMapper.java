package com.bdomanager.application.recipe.mapper;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipeItem.models.RecipeItemApplicationMapper;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.domain.recipeItem.RecipeItem;
import java.util.List;

public class RecipeApplicationMapper {

    // Command -> Model

        public static Recipe createCommandToModel(CreateRecipeCommand command){
            List<RecipeItem> items = command.items()
                                                 .stream()
                                                 .map(RecipeItemApplicationMapper::createCommandToModel)
                                                 .toList();

            return new Recipe(command.description(),
                                   items);
        }

        public static Recipe updateCommandToModel(UpdateRecipeCommand command){
            List<RecipeItem> items = command.items()
                    .stream()
                    .map(RecipeItemApplicationMapper::updateCommandToModel)
                    .toList();

            return new Recipe(command.id(),
                                   command.description(),
                                   items);
        }
}
