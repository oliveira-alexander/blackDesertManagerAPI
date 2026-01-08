package com.bdomanager.application.item.mapper;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.domain.item.Item;

public class ItemApplicationMapper {

    // Command -> Model

        public static Item createCommandToModel(CreateItemCommand command){
            return new Item(command.description(),
                                 command.marketPrice(),
                                 command.productionCost());
        }

        public static Item updateCommandToModel(UpdateItemCommand command){
            return new Item(command.id(),
                                 command.description(),
                                 command.marketPrice(),
                                 command.productionCost());
        }
}
