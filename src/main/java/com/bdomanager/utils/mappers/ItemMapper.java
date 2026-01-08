package com.bdomanager.utils.mappers;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.domain.item.model.ItemModel;
import com.bdomanager.infrastructure.dtos.item.*;
import com.bdomanager.infrastructure.entities.ItemEntity;

public final class ItemMapper {

    // Input DTO -> Commands

    public static CreateItemCommand dtoToCreateItemCommand(ItemInputDTO dto){
        return new CreateItemCommand(dto.description(),
                dto.marketPrice(),
                dto.productionCost());
    }

    public static UpdateItemCommand dtoToUpdateItemCommand(ItemInputDTO dto){
        return new UpdateItemCommand(dto.id(),
                                     dto.description(),
                                     dto.marketPrice(),
                                     dto.productionCost());
    }

    // Command -> Domain Model

    public static ItemModel createItemCommandToItem(CreateItemCommand command){
        return new ItemModel(command.description(),
                        command.marketPrice(),
                        command.productionCost());
    }

    public static ItemModel updateItemCommandToItem(UpdateItemCommand command){
        return new ItemModel(command.id(),
                        command.description(),
                        command.marketPrice(),
                        command.productionCost());
    }

    // Domain Model -> Infrastructure Entity

    public static ItemEntity itemToItemEntity(ItemModel itemModel){
        return new ItemEntity(itemModel.getId(),
                              itemModel.getDescription(),
                              itemModel.getMarketPrice(),
                              itemModel.getProductionCost());
    }

    // Infrastructure Entity -> Domain Model

    public static ItemModel itemEntityToItem(ItemEntity entity){
        return new ItemModel(entity.getId(),
                        entity.getDescription(),
                        entity.getMarketPrice(),
                        entity.getProductionCost());
    }

    // Domain Model -> Output DTO

    public static ItemOutputDTO itemToOutputDTO(ItemModel itemModel){
        return new ItemOutputDTO(itemModel.getId(),
                                 itemModel.getDescription(),
                                 itemModel.getMarketPrice(),
                                 itemModel.getProductionCost());
    }
}
