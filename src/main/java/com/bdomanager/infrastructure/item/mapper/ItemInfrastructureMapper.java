package com.bdomanager.infrastructure.item.mapper;

import com.bdomanager.application.item.dtos.ItemInputDTO;
import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.infrastructure.item.entity.ItemEntity;
import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.domain.item.Item;

public class ItemInfrastructureMapper {

    // DTO -> Command

        public static CreateItemCommand dtoToCreateCommand(ItemInputDTO dto){
            return new CreateItemCommand(dto.description(),
                                         dto.marketPrice(),
                                         dto.productionCost());
        }

        public static UpdateItemCommand dtoToUpdateCommand(ItemInputDTO dto){
            return new UpdateItemCommand(dto.id(),
                                         dto.description(),
                                         dto.marketPrice(),
                                         dto.productionCost());
        }

    // Model -> Entity

        public static ItemEntity modelToEntity(Item model){
            return new ItemEntity(model.getId(),
                                  model.getDescription(),
                                  model.getMarketPrice(),
                                  model.getProductionCost());
        }

    // Entity -> Model

        public static Item entityToModel(ItemEntity entity){
            return new Item(entity.getId(),
                                 entity.getDescription(),
                                 entity.getMarketPrice(),
                                 entity.getProductionCost());
        }

    // Model -> DTO (Output)

        public static ItemOutputDTO modelToDTO(Item model){
            return new ItemOutputDTO(model.getId(),
                                     model.getDescription(),
                                     model.getMarketPrice(),
                                     model.getProductionCost());
        }
}
