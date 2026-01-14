package com.bdomanager.application.item.useCases;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.domain.item.Item;

public interface CreateItemUseCase {
    ItemOutputDTO execute(CreateItemCommand command);
}
