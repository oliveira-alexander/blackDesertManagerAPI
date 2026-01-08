package com.bdomanager.infrastructure.adapt.controllers;

import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.application.item.useCases.*;
import com.bdomanager.infrastructure.dtos.item.*;
import com.bdomanager.utils.mappers.ItemMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/item")
public class ItemController {

    private final CreateItemUseCase createItemUseCase;
    private final UpdateItemUseCase updateItemUseCase;
    private final GetAllItemsUseCase getAllItemsUseCase;
    private final GetItemByIdUseCase getByIdUseCase;
    private final DeleteItemUseCase deleteItemUseCase;

    public ItemController(CreateItemUseCase createItemUseCase,
                          UpdateItemUseCase updateItemUseCase,
                          GetAllItemsUseCase getAllItemsUseCase,
                          GetItemByIdUseCase getByIdUseCase,
                          DeleteItemUseCase deleteItemUseCase){
        this.createItemUseCase = createItemUseCase;
        this.updateItemUseCase = updateItemUseCase;
        this.getAllItemsUseCase = getAllItemsUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.deleteItemUseCase = deleteItemUseCase;
    }

    @PostMapping
    public ItemOutputDTO create (@RequestBody ItemInputDTO newItem){
        CreateItemCommand command = ItemMapper.dtoToCreateItemCommand(newItem);
        return ItemMapper.itemToOutputDTO(createItemUseCase.execute(command));
    }

    @GetMapping
    public List<ItemOutputDTO> getAll(){
        return getAllItemsUseCase.execute()
                                 .stream()
                                 .map(ItemMapper::itemToOutputDTO)
                                 .toList();
    }

    @GetMapping("/{id}")
    public ItemOutputDTO getById(@PathVariable("id") Long id){
        return ItemMapper.itemToOutputDTO(getByIdUseCase.execute(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        deleteItemUseCase.execute(id);
    }

    @PutMapping
    public ItemOutputDTO update(@RequestBody ItemInputDTO updatingItem){
        UpdateItemCommand command = ItemMapper.dtoToUpdateItemCommand(updatingItem);
        return ItemMapper.itemToOutputDTO(updateItemUseCase.execute(command));
    }
}
