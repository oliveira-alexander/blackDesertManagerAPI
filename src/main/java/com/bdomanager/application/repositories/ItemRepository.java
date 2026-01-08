package com.bdomanager.Application.repositories;

import com.bdomanager.domain.item.model.Item;

import java.util.List;

public interface ItemRepository {
    Item getById(Long id);
    List<Item> getAll();

    Item create(Item item);
    Item update(Item item);
    void delete(Long id);

    boolean existsByDescription(String description);
}