package com.bdomanager.application.useCases.item.impl;

import com.bdomanager.application.commands.item.CreateItemCommand;
import com.bdomanager.application.useCases.item.CreateItemUseCase;
import com.bdomanager.domain.models.Item;
import com.bdomanager.domain.repositories.ItemRepository;
import com.bdomanager.utils.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateItemUseCaseImpl implements CreateItemUseCase {

    private final ItemRepository repository;

    public CreateItemUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public Item execute(CreateItemCommand command) {
        Item item = ItemMapper.createItemCommandToItem(command);

        return repository.create(item);
    }
}
