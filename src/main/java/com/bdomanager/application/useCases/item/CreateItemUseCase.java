package com.bdomanager.application.useCases.item;

import com.bdomanager.application.commands.item.CreateItemCommand;
import com.bdomanager.domain.models.Item;

public interface CreateItemUseCase {
    Item execute(CreateItemCommand command);
}
