package com.bdomanager.infrastructure.adapt.controllers;

import com.bdomanager.application.commands.recipe.CreateRecipeCommand;
import com.bdomanager.application.useCases.recipe.*;
import com.bdomanager.infrastructure.dtos.recipe.*;
import com.bdomanager.utils.mappers.RecipeMapper;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final CreateRecipeUseCase createRecipeUseCase;
    private final GetAllRecipesUseCase getAllRecipesUseCase;
    private final GetRecipeByIdUseCase getRecipeByIdUseCase;
    private final DeleteRecipeUseCase deleteRecipeUseCase;
    private final UpdateRecipeUseCase updateRecipeUseCase;

    public RecipeController(CreateRecipeUseCase createRecipeUseCase,
                            GetAllRecipesUseCase getAllRecipesUseCase,
                            GetRecipeByIdUseCase getRecipeByIdUseCase,
                            DeleteRecipeUseCase deleteRecipeUseCase,
                            UpdateRecipeUseCase updateRecipeUseCase){
        this.createRecipeUseCase = createRecipeUseCase;
        this.getAllRecipesUseCase = getAllRecipesUseCase;
        this.getRecipeByIdUseCase = getRecipeByIdUseCase;
        this.deleteRecipeUseCase = deleteRecipeUseCase;
        this.updateRecipeUseCase = updateRecipeUseCase;
    }

    @PostMapping
    public RecipeOutputDTO create(@RequestBody RecipeInputDTO newRecipe){
        CreateRecipeCommand command = RecipeMapper.inputDTOToCreateCommand(newRecipe);
        return RecipeMapper.recipeModelToRecipeDTO(createRecipeUseCase.execute(command));
    }

    @GetMapping
    public List<RecipeOutputDTO> getAll(){
        return getAllRecipesUseCase.execute().stream()
                .map(RecipeMapper::recipeModelToRecipeDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public RecipeOutputDTO getById(@PathVariable Long id){
        return RecipeMapper.recipeModelToRecipeDTO(getRecipeByIdUseCase.execute(id));
    }

    @PutMapping
    public RecipeOutputDTO update(@RequestBody RecipeInputDTO updatingRecipe){
        return RecipeMapper.recipeModelToRecipeDTO(
                updateRecipeUseCase.execute(
                        RecipeMapper.inputDTOToUpdateCommand(updatingRecipe)
                )
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        deleteRecipeUseCase.execute(id);
    }
}
