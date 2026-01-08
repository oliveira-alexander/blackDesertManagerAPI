package com.bdomanager.application.item.useCases.impl;

import com.bdomanager.application.item.useCases.DeleteItemUseCase;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteItemUseCaseImpl implements DeleteItemUseCase {

    private final ItemRepository repository;

    public DeleteItemUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public void execute(Long id) {
        repository.delete(id);
    }
}
