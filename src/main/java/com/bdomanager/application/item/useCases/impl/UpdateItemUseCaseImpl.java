package com.bdomanager.application.item.useCases.impl;

import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.application.item.mapper.ItemApplicationMapper;
import com.bdomanager.application.item.useCases.UpdateItemUseCase;
import com.bdomanager.domain.item.Item;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateItemUseCaseImpl implements UpdateItemUseCase {

    private final ItemRepository repository;

    public UpdateItemUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public ItemOutputDTO execute(UpdateItemCommand command) {
        Item item = ItemApplicationMapper.updateCommandToModel(command);
        return ItemApplicationMapper.modelToDTO(this.repository.update(item));
    }
}
