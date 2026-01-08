package com.bdomanager.application.item.useCases;

import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.domain.item.model.ItemModel;

public interface UpdateItemUseCase {
    ItemModel execute(UpdateItemCommand command);
}
