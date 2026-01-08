package com.bdomanager.application.item.useCases.impl;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.mapper.ItemApplicationMapper;
import com.bdomanager.application.item.useCases.CreateItemUseCase;
import com.bdomanager.domain.item.Item;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateItemUseCaseImpl implements CreateItemUseCase {

    private final ItemRepository repository;

    public CreateItemUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public Item execute(CreateItemCommand command) {
        Item item = ItemApplicationMapper.createCommandToModel(command);
        return repository.create(item);
    }
}
