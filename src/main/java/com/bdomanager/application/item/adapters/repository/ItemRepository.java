package com.bdomanager.application.item.adapters.repository;

import com.bdomanager.domain.item.model.ItemModel;

import java.util.List;

public interface ItemRepository {
    ItemModel getById(Long id);
    List<ItemModel> getAll();

    ItemModel create(ItemModel itemModel);
    ItemModel update(ItemModel itemModel);
    void delete(Long id);
}