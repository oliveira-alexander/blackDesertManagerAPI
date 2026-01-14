package com.bdomanager.application.item.useCases;

import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.domain.item.Item;

public interface UpdateItemUseCase {
    ItemOutputDTO execute(UpdateItemCommand command);
}
