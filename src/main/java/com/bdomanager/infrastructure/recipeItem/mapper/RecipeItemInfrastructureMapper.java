package com.bdomanager.infrastructure.recipeItem.mapper;

import com.bdomanager.infrastructure.recipeItem.dtos.RecipeItemInputDTO;
import com.bdomanager.infrastructure.recipeItem.dtos.RecipeItemOutputDTO;
import com.bdomanager.application.recipeItem.commands.CreateRecipeItemCommand;
import com.bdomanager.application.recipeItem.commands.UpdateRecipeItemCommand;
import com.bdomanager.domain.recipeItem.RecipeItem;

public class RecipeItemInfrastructureMapper {

    // DTO -> Command

        public static CreateRecipeItemCommand dtoToCreateCommand(RecipeItemInputDTO dto){
            return new CreateRecipeItemCommand(dto.itemId(),
                                               dto.quantity());
        }

        public static UpdateRecipeItemCommand dtoToUpdateCommand(RecipeItemInputDTO dto){
            return new UpdateRecipeItemCommand(dto.id(),
                                               dto.itemId(),
                                               dto.quantity());
        }

     // Model -> DTO

        public static RecipeItemOutputDTO modelToDTO(RecipeItem model){
            return new RecipeItemOutputDTO(model.getIdItem(), model.getQuantity());
        }
}
