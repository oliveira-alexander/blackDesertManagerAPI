package com.bdomanager.infrastructure.adapt.repositories.impl;

import com.bdomanager.domain.item.model.ItemModel;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.infrastructure.adapt.repositories.ItemJPARepository;
import com.bdomanager.infrastructure.entities.ItemEntity;
import com.bdomanager.utils.mappers.ItemMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJPARepository jpaRepository;

    public ItemRepositoryImpl(ItemJPARepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ItemModel getById(Long id) {
        return ItemMapper.itemEntityToItem(jpaRepository.findById(id).get());
    }

    @Override
    public List<ItemModel> getAll() {
        List<ItemEntity> itemsEntity = jpaRepository.findAll();
        return itemsEntity.stream()
                .map(ItemMapper::itemEntityToItem)
                .toList();
    }

    @Override
    public ItemModel create(ItemModel itemModel) {
        ItemEntity newItem = ItemMapper.itemToItemEntity(itemModel);
        jpaRepository.save(newItem);

        return ItemMapper.itemEntityToItem(newItem);
    }

    @Override
    public ItemModel update(ItemModel itemModel) {
        ItemEntity updatingItem = ItemMapper.itemToItemEntity(itemModel);
        jpaRepository.save(updatingItem);

        return ItemMapper.itemEntityToItem(updatingItem);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByDescription(String description) {
        return false;
    }
}
