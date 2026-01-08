package com.bdomanager.application.useCases.item.impl;

import com.bdomanager.application.useCases.item.DeleteItemUseCase;
import com.bdomanager.Application.repositories.ItemRepository;
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
