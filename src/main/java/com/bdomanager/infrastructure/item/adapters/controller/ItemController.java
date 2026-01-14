package com.bdomanager.infrastructure.item.adapters.controller;

import com.bdomanager.application.item.dtos.ItemInputDTO;
import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.infrastructure.item.mapper.ItemInfrastructureMapper;
import com.bdomanager.application.item.commands.CreateItemCommand;
import com.bdomanager.application.item.commands.UpdateItemCommand;
import com.bdomanager.application.item.useCases.*;
import com.bdomanager.infrastructure.utils.response.ResponseEnvelope;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<ResponseEnvelope<ItemOutputDTO>>  create (@RequestBody @Valid ItemInputDTO dto){
        CreateItemCommand command = ItemInfrastructureMapper.dtoToCreateCommand(dto);
        ItemOutputDTO output = ItemInfrastructureMapper.modelToDTO(createItemUseCase.execute(command));

        ResponseEnvelope<ItemOutputDTO> response = new ResponseEnvelope<ItemOutputDTO>(LocalDateTime.now(),
                                                                        output,
                                                                        "Item criado com sucesso!");

        return new ResponseEntity<ResponseEnvelope<ItemOutputDTO>>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseEnvelope<List<ItemOutputDTO>>> getAll(){

        List<ItemOutputDTO> output = getAllItemsUseCase.execute()
                                                       .stream()
                                                       .map(ItemInfrastructureMapper::modelToDTO)
                                                       .toList();

        ResponseEnvelope<List<ItemOutputDTO>> response = new ResponseEnvelope<>(LocalDateTime.now(),
                                                                                output,
                                                                                "");

        return new ResponseEntity<ResponseEnvelope<List<ItemOutputDTO>>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEnvelope<ItemOutputDTO>> getById(@PathVariable("id") Long id){
        ItemOutputDTO item = ItemInfrastructureMapper.modelToDTO(getByIdUseCase.execute(id));

        ResponseEnvelope<ItemOutputDTO> output = new ResponseEnvelope<>(LocalDateTime.now(),
                                                                        item,
                                                                         null);

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseEnvelope<String>> delete(@PathVariable("id") Long id){
        deleteItemUseCase.execute(id);

        ResponseEnvelope<String> output = new ResponseEnvelope<>(LocalDateTime.now(),
                                                                 null,
                                                                  null);

        return new ResponseEntity<>(output, HttpStatus.valueOf(204));
    }

    @PutMapping
    public ResponseEntity<ResponseEnvelope<ItemOutputDTO>> update(@RequestBody @Valid ItemInputDTO updatingItem){
        UpdateItemCommand command = ItemInfrastructureMapper.dtoToUpdateCommand(updatingItem);
        ItemOutputDTO output = ItemInfrastructureMapper.modelToDTO(updateItemUseCase.execute(command));

        ResponseEnvelope<ItemOutputDTO> response = new ResponseEnvelope<>(LocalDateTime.now(),
                                                                          output,
                                                                          "Item atualizado com sucesso!");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
