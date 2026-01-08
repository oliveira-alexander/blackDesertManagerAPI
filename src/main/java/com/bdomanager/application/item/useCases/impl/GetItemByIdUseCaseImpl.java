package com.bdomanager.application.item.useCases.impl;

import com.bdomanager.application.item.useCases.GetItemByIdUseCase;
import com.bdomanager.domain.item.model.ItemModel;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class GetItemByIdUseCaseImpl implements GetItemByIdUseCase {

    private final ItemRepository repository;

    public GetItemByIdUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public ItemModel execute(Long id) {
        return repository.getById(id);
    }
}
