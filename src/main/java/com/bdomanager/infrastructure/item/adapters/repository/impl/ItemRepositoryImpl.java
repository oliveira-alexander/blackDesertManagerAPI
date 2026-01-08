package com.bdomanager.Infrastructure.item.adapters.repository.impl;

import com.bdomanager.Infrastructure.item.mapper.ItemInfrastructureMapper;
import com.bdomanager.domain.item.model.ItemModel;
import com.bdomanager.application.item.adapters.repository.ItemRepository;
import com.bdomanager.Infrastructure.item.adapters.repository.ItemJPARepository;
import com.bdomanager.Infrastructure.item.entity.ItemEntity;
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
        return ItemInfrastructureMapper.entityToModel(jpaRepository.findById(id).get());
    }

    @Override
    public List<ItemModel> getAll() {
        List<ItemEntity> itemsEntity = jpaRepository.findAll();
        return itemsEntity.stream()
                .map(ItemInfrastructureMapper::entityToModel)
                .toList();
    }

    @Override
    public ItemModel create(ItemModel itemModel) {
        ItemEntity newItem = ItemInfrastructureMapper.modelToEntity(itemModel);
        jpaRepository.save(newItem);

        return ItemInfrastructureMapper.entityToModel(newItem);
    }

    @Override
    public ItemModel update(ItemModel itemModel) {
        ItemEntity updatingItem = ItemInfrastructureMapper.modelToEntity(itemModel);
        jpaRepository.save(updatingItem);

        return ItemInfrastructureMapper.entityToModel(updatingItem);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

}
