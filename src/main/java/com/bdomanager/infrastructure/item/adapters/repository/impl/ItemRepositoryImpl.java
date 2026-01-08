package com.bdomanager.infrastructure.item.adapters.repository.impl;

import com.bdomanager.infrastructure.item.mapper.ItemInfrastructureMapper;
import com.bdomanager.domain.item.Item;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.infrastructure.item.adapters.repository.ItemJPARepository;
import com.bdomanager.infrastructure.item.entity.ItemEntity;
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
        return ItemInfrastructureMapper.entityToModel(jpaRepository.findById(id).get());
    }

    @Override
    public List<Item> getAll() {
        List<ItemEntity> itemsEntity = jpaRepository.findAll();
        return itemsEntity.stream()
                .map(ItemInfrastructureMapper::entityToModel)
                .toList();
    }

    @Override
    public Item create(Item item) {
        ItemEntity newItem = ItemInfrastructureMapper.modelToEntity(item);
        jpaRepository.save(newItem);

        return ItemInfrastructureMapper.entityToModel(newItem);
    }

    @Override
    public Item update(Item item) {
        ItemEntity updatingItem = ItemInfrastructureMapper.modelToEntity(item);
        jpaRepository.save(updatingItem);

        return ItemInfrastructureMapper.entityToModel(updatingItem);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

}
