package com.bdomanager.services;

import com.bdomanager.dtos.item.ItemInputDTO;
import com.bdomanager.dtos.item.ItemOutputDTO;

import java.util.List;

public interface ItemService {
    ItemOutputDTO create(ItemInputDTO newItem);
    ItemOutputDTO update(ItemInputDTO updatingItem);
    void delete(Long id);

    List<ItemOutputDTO> getAll();
    ItemOutputDTO getById(Long id);
}
