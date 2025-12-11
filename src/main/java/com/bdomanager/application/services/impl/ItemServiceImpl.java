package com.bdomanager.application.services.impl;

import com.bdomanager.infrastructure.dtos.item.ItemInputDTO;
import com.bdomanager.infrastructure.dtos.item.ItemOutputDTO;
import com.bdomanager.domain.models.Item;
import com.bdomanager.infrastructure.exceptions.items.ItemAlreadyExists;
import com.bdomanager.application.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl {

//    @Autowired
//    private ItemRepository repository;
//
//    @Override
//    public ItemOutputDTO create(ItemInputDTO newItem) {
//        Item item = new Item(newItem.description(), newItem.marketPrice(), newItem.productionCost());
//
//        if (repository.existsByDescription(item.getDescription()))
//            throw new ItemAlreadyExists();
//        else
//            repository.save(item);
//
//        return new ItemOutputDTO(item.getId(),
//                                 item.getDescription(),
//                                 item.getMarketPrice(),
//                                 item.getProductionCost());
//    }
//
//    @Override
//    public ItemOutputDTO update(ItemInputDTO updatingItem) {
//        Item item = repository.findById(updatingItem.id()).get();
//
//        item.setDescription(updatingItem.description());
//        item.setMarketPrice(updatingItem.marketPrice());
//        item.setProductionCost(updatingItem.productionCost());
//
//        repository.save(item);
//
//        return new ItemOutputDTO(updatingItem.id(),
//                                 updatingItem.description(),
//                                 updatingItem.marketPrice(),
//                                 updatingItem.productionCost());
//    }
//
//    @Override
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public List<ItemOutputDTO> getAll() {
//        List<Item> items = repository.findAll();
//        List<ItemOutputDTO> outputList = new ArrayList<>();
//
//        items.stream().forEach(item -> outputList.add(new ItemOutputDTO(item.getId(),
//                                                                             item.getDescription(),
//                                                                             item.getMarketPrice(),
//                                                                             item.getProductionCost())));
//
//        return outputList;
//    }
//
//    @Override
//    public ItemOutputDTO getById(Long id) {
//        Item item = new Item();
//
//        if (repository.existsById(id))
//            item = repository.findById(id).get();
//
//        return new ItemOutputDTO(item.getId(),
//                                 item.getDescription(),
//                                 item.getMarketPrice(),
//                                 item.getProductionCost());
//    }
}
