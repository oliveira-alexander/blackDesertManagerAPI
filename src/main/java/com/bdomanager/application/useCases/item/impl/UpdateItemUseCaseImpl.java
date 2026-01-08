package com.bdomanager.application.useCases.item.impl;

import com.bdomanager.application.commands.item.UpdateItemCommand;
import com.bdomanager.domain.item.model.Item;
import com.bdomanager.Application.repositories.ItemRepository;
import com.bdomanager.utils.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateItemUseCaseImpl implements com.bdomanager.application.useCases.item.UpdateItemUseCase {

    private final ItemRepository repository;

    public UpdateItemUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public Item execute(UpdateItemCommand command) {
        Item item = ItemMapper.updateItemCommandToItem(command);
        return this.repository.update(item);
    }
}
