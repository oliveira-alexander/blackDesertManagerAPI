package com.bdomanager.application.item.useCases;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.domain.item.model.ItemModel;

public interface CreateItemUseCase {
    ItemModel execute(CreateItemCommand command);
}
