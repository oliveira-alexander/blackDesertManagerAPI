package com.bdomanager.application.recipe.mapper;

import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.commands.UpdateRecipeCommand;
import com.bdomanager.application.recipeItem.models.RecipeItemApplicationMapper;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.domain.recipeItem.model.RecipeItemModel;
import java.util.List;

public class RecipeApplicationMapper {

    // Command -> Model

        public static RecipeModel createCommandToModel(CreateRecipeCommand command){
            List<RecipeItemModel> items = command.items()
                                                 .stream()
                                                 .map(RecipeItemApplicationMapper::createCommandToModel)
                                                 .toList();

            return new RecipeModel(command.description(),
                                   items);
        }

        public static RecipeModel updateCommandToModel(UpdateRecipeCommand command){
            List<RecipeItemModel> items = command.items()
                    .stream()
                    .map(RecipeItemApplicationMapper::updateCommandToModel)
                    .toList();

            return new RecipeModel(command.id(),
                                   command.description(),
                                   items);
        }
}
