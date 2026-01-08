package com.bdomanager.application.item.adapters.repository;

import com.bdomanager.domain.item.Item;

import java.util.List;

public interface ItemRepository {
    Item getById(Long id);
    List<Item> getAll();

    Item create(Item item);
    Item update(Item item);
    void delete(Long id);
}