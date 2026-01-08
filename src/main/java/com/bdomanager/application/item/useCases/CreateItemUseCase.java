package com.bdomanager.application.item.useCases;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.domain.item.Item;

public interface CreateItemUseCase {
    Item execute(CreateItemCommand command);
}
