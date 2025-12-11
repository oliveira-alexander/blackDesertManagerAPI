package com.bdomanager.infrastructure.adapt.repositories.impl;

import com.bdomanager.domain.models.Item;
import com.bdomanager.domain.repositories.ItemRepository;
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
    public Item getById(Long id) {
        return ItemMapper.itemEntityToItem(jpaRepository.findById(id).get());
    }

    @Override
    public List<Item> getAll() {
        List<ItemEntity> itemsEntity = jpaRepository.findAll();
        return itemsEntity.stream()
                .map(ItemMapper::itemEntityToItem)
                .toList();
    }

    @Override
    public Item create(Item item) {
        ItemEntity newItem = ItemMapper.itemToItemEntity(item);
        jpaRepository.save(newItem);

        return ItemMapper.itemEntityToItem(newItem);
    }

    @Override
    public Item update(Item item) {
        ItemEntity updatingItem = ItemMapper.itemToItemEntity(item);
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
