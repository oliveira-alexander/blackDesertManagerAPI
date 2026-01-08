package com.bdomanager.application.useCases.item.impl;

import com.bdomanager.application.useCases.item.GetItemByIdUseCase;
import com.bdomanager.domain.item.model.Item;
import com.bdomanager.Application.repositories.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class GetItemByIdUseCaseImpl implements GetItemByIdUseCase {

    private final ItemRepository repository;

    public GetItemByIdUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public Item execute(Long id) {
        return repository.getById(id);
    }
}
