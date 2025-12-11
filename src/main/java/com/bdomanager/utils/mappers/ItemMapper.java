package com.bdomanager.utils.mappers;

import com.bdomanager.application.commands.item.*;
import com.bdomanager.domain.models.Item;
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

    public static Item createItemCommandToItem(CreateItemCommand command){
        return new Item(command.description(),
                        command.marketPrice(),
                        command.productionCost());
    }

    public static Item updateItemCommandToItem(UpdateItemCommand command){
        return new Item(command.id(),
                        command.description(),
                        command.marketPrice(),
                        command.productionCost());
    }

    // Domain Model -> Infrastructure Entity

    public static ItemEntity itemToItemEntity(Item item){
        return new ItemEntity(item.getId(),
                              item.getDescription(),
                              item.getMarketPrice(),
                              item.getProductionCost());
    }

    // Infrastructure Entity -> Domain Model

    public static Item itemEntityToItem(ItemEntity entity){
        return new Item(entity.getId(),
                        entity.getDescription(),
                        entity.getMarketPrice(),
                        entity.getProductionCost());
    }

    // Domain Model -> Output DTO

    public static ItemOutputDTO itemToOutputDTO(Item item){
        return new ItemOutputDTO(item.getId(),
                                 item.getDescription(),
                                 item.getMarketPrice(),
                                 item.getProductionCost());
    }
}
