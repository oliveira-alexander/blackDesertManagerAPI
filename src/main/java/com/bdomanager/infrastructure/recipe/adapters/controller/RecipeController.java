package com.bdomanager.infrastructure.recipe.adapters.controller;

import com.bdomanager.infrastructure.recipe.dtos.RecipeInputDTO;
import com.bdomanager.infrastructure.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.infrastructure.recipe.mapper.RecipeInfrastructureMapper;
import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.useCases.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/recipe")
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
    public RecipeOutputDTO create(@RequestBody RecipeInputDTO dto){
        CreateRecipeCommand command = RecipeInfrastructureMapper.dtoToCreateCommand(dto);
        return RecipeInfrastructureMapper.modelToDTO(createRecipeUseCase.execute(command));
    }

    @GetMapping
    public List<RecipeOutputDTO> getAll(){
        return getAllRecipesUseCase.execute()
                                   .stream()
                                   .map(RecipeInfrastructureMapper::modelToDTO)
                                   .toList();
    }

    @GetMapping("/{id}")
    public RecipeOutputDTO getById(@PathVariable Long id){
        return RecipeInfrastructureMapper.modelToDTO(getRecipeByIdUseCase.execute(id));
    }

    @PutMapping
    public RecipeOutputDTO update(@RequestBody RecipeInputDTO dto){
        return RecipeInfrastructureMapper.modelToDTO(
                updateRecipeUseCase.execute(
                        RecipeInfrastructureMapper.dtoToUpdateCommand(dto)
                )
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        deleteRecipeUseCase.execute(id);
    }
}
