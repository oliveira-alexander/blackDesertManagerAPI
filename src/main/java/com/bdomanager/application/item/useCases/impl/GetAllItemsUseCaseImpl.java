package com.bdomanager.application.item.useCases.impl;

import com.bdomanager.application.item.useCases.GetAllItemsUseCase;
import com.bdomanager.domain.item.model.ItemModel;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllItemsUseCaseImpl implements GetAllItemsUseCase {

    private final ItemRepository repository;

    public GetAllItemsUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public List<ItemModel> execute() {
        return repository.getAll();
    }
}
