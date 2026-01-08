package com.bdomanager.Infrastructure.item.mapper;

import com.bdomanager.Infrastructure.item.dtos.ItemInputDTO;
import com.bdomanager.Infrastructure.item.dtos.ItemOutputDTO;
import com.bdomanager.Infrastructure.item.entity.ItemEntity;
import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.domain.item.model.ItemModel;

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

        public static ItemEntity modelToEntity(ItemModel model){
            return new ItemEntity(model.getId(),
                                  model.getDescription(),
                                  model.getMarketPrice(),
                                  model.getProductionCost());
        }

    // Entity -> Model

        public static ItemModel entityToModel(ItemEntity entity){
            return new ItemModel(entity.getId(),
                                 entity.getDescription(),
                                 entity.getMarketPrice(),
                                 entity.getProductionCost());
        }

    // Model -> DTO (Output)

        public static ItemOutputDTO modelToDTO(ItemModel model){
            return new ItemOutputDTO(model.getId(),
                                     model.getDescription(),
                                     model.getMarketPrice(),
                                     model.getProductionCost());
        }
}
