package com.bdomanager.controllers;

import com.bdomanager.dtos.recipe.RecipeInputDTO;
import com.bdomanager.dtos.recipe.RecipeOutputDTO;
import com.bdomanager.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @PostMapping
    public RecipeOutputDTO create(@RequestBody RecipeInputDTO newRecipe){
        return service.create(newRecipe);
    }

    @GetMapping
    public List<RecipeOutputDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RecipeOutputDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping
    public RecipeOutputDTO update(@RequestBody RecipeInputDTO updatingRecipe){
        return service.update(updatingRecipe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
