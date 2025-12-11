package com.bdomanager.domain.repositories;

import com.bdomanager.domain.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item getById(Long id);
    List<Item> getAll();

    Item create(Item item);
    Item update(Item item);
    void delete(Long id);

    boolean existsByDescription(String description);
}