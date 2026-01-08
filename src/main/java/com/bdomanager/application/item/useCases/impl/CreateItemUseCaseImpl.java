package com.bdomanager.application.item.useCases.impl;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.useCases.CreateItemUseCase;
import com.bdomanager.domain.item.model.ItemModel;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.utils.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateItemUseCaseImpl implements CreateItemUseCase {

    private final ItemRepository repository;

    public CreateItemUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public ItemModel execute(CreateItemCommand command) {
        ItemModel itemModel = ItemMapper.createItemCommandToItem(command);

        return repository.create(itemModel);
    }
}
