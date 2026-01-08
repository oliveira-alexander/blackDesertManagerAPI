package com.bdomanager.application.useCases.item;

import com.bdomanager.application.commands.item.CreateItemCommand;
import com.bdomanager.domain.item.model.Item;

public interface CreateItemUseCase {
    Item execute(CreateItemCommand command);
}
