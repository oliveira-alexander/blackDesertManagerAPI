package com.bdomanager.application.services;

import com.bdomanager.infrastructure.dtos.item.ItemInputDTO;
import com.bdomanager.infrastructure.dtos.item.ItemOutputDTO;

import java.util.List;

public interface ItemService {
    ItemOutputDTO create(ItemInputDTO newItem);
    ItemOutputDTO update(ItemInputDTO updatingItem);
    void delete(Long id);

    List<ItemOutputDTO> getAll();
    ItemOutputDTO getById(Long id);
}
