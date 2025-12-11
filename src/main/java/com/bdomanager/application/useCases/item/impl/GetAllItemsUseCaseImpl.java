package com.bdomanager.application.useCases.item.impl;

import com.bdomanager.application.useCases.item.GetAllItemsUseCase;
import com.bdomanager.domain.models.Item;
import com.bdomanager.domain.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllItemsUseCaseImpl implements GetAllItemsUseCase {

    private final ItemRepository repository;

    public GetAllItemsUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Item> execute() {
        return repository.getAll();
    }
}
