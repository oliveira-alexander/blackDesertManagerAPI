package com.bdomanager.application.item.mapper;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.domain.item.model.ItemModel;

public class ItemApplicationMapper {

    // Command -> Model

        public static ItemModel createCommandToModel(CreateItemCommand command){
            return new ItemModel(command.description(),
                                 command.marketPrice(),
                                 command.productionCost());
        }

        public static ItemModel updateCommandToModel(UpdateItemCommand command){
            return new ItemModel(command.id(),
                                 command.description(),
                                 command.marketPrice(),
                                 command.productionCost());
        }
}
