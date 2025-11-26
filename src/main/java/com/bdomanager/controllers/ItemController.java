package com.bdomanager.controllers;

import com.bdomanager.dtos.item.ItemInputDTO;
import com.bdomanager.dtos.item.ItemOutputDTO;
import com.bdomanager.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public ItemOutputDTO create (@RequestBody ItemInputDTO newItem){
        return service.create(newItem);
    }

    @GetMapping
    public List<ItemOutputDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ItemOutputDTO getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PutMapping
    public ItemOutputDTO update(@RequestBody ItemInputDTO updatingItem){
        return service.update(updatingItem);
    }
}
