package com.bdomanager.application.item.useCases.impl;

import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.application.item.mapper.ItemApplicationMapper;
import com.bdomanager.application.item.useCases.GetItemByIdUseCase;
import com.bdomanager.domain.item.Item;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class GetItemByIdUseCaseImpl implements GetItemByIdUseCase {

    private final ItemRepository repository;

    public GetItemByIdUseCaseImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public ItemOutputDTO execute(Long id) {
        return ItemApplicationMapper.modelToDTO(repository.getById(id));
    }
}
