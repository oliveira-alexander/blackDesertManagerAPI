package com.bdomanager.infrastructure.item.adapters.controller;

import com.bdomanager.application.item.dtos.ItemInputDTO;
import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.infrastructure.item.mapper.ItemInfrastructureMapper;
import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.application.item.useCases.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/item")
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
    public ItemOutputDTO create (@RequestBody @Valid ItemInputDTO dto){
        CreateItemCommand command = ItemInfrastructureMapper.dtoToCreateCommand(dto);
        return ItemInfrastructureMapper.modelToDTO(createItemUseCase.execute(command));
    }

    @GetMapping
    public List<ItemOutputDTO> getAll(){
        return getAllItemsUseCase.execute()
                                 .stream()
                                 .map(ItemInfrastructureMapper::modelToDTO)
                                 .toList();
    }

    @GetMapping("/{id}")
    public ItemOutputDTO getById(@PathVariable("id") Long id){
        return ItemInfrastructureMapper.modelToDTO(getByIdUseCase.execute(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        deleteItemUseCase.execute(id);
    }

    @PutMapping
    public ItemOutputDTO update(@RequestBody @Valid ItemInputDTO updatingItem){
        UpdateItemCommand command = ItemInfrastructureMapper.dtoToUpdateCommand(updatingItem);
        return ItemInfrastructureMapper.modelToDTO(updateItemUseCase.execute(command));
    }
}
