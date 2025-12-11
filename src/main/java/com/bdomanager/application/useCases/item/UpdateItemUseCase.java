package com.bdomanager.application.useCases.item;

import com.bdomanager.application.commands.item.UpdateItemCommand;
import com.bdomanager.domain.models.Item;

public interface UpdateItemUseCase {
    Item execute(UpdateItemCommand command);
}
