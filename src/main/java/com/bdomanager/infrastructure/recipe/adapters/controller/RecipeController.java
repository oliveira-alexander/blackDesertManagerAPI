package com.bdomanager.infrastructure.recipe.adapters.controller;

import com.bdomanager.application.recipe.dtos.RecipeInputDTO;
import com.bdomanager.application.recipe.dtos.RecipeOutputDTO;
import com.bdomanager.infrastructure.recipe.mapper.RecipeInfrastructureMapper;
import com.bdomanager.application.recipe.commands.CreateRecipeCommand;
import com.bdomanager.application.recipe.useCases.*;
import com.bdomanager.infrastructure.utils.response.ResponseEnvelope;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<ResponseEnvelope<RecipeOutputDTO>> create(@RequestBody @Valid RecipeInputDTO dto){
        CreateRecipeCommand command = RecipeInfrastructureMapper.dtoToCreateCommand(dto);
        RecipeOutputDTO output = RecipeInfrastructureMapper.modelToDTO(createRecipeUseCase.execute(command));

        ResponseEnvelope<RecipeOutputDTO> response = new ResponseEnvelope<>(LocalDateTime.now(),
                                                                            output, "Receita criada com sucesso!");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseEnvelope<List<RecipeOutputDTO>>> getAll(){
        List<RecipeOutputDTO> output =  getAllRecipesUseCase.execute()
                                                            .stream()
                                                            .map(RecipeInfrastructureMapper::modelToDTO)
                                                            .toList();

        ResponseEnvelope<List<RecipeOutputDTO>> response = new ResponseEnvelope<>(LocalDateTime.now(),
                output, null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEnvelope<RecipeOutputDTO>> getById(@PathVariable Long id){
        RecipeOutputDTO output = RecipeInfrastructureMapper.modelToDTO(getRecipeByIdUseCase.execute(id));

        ResponseEnvelope<RecipeOutputDTO> response = new ResponseEnvelope<>(LocalDateTime.now(),
                output, null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseEnvelope<RecipeOutputDTO>> update(@RequestBody @Valid RecipeInputDTO dto){
        RecipeOutputDTO output =  RecipeInfrastructureMapper.modelToDTO(
                updateRecipeUseCase.execute(
                        RecipeInfrastructureMapper.dtoToUpdateCommand(dto)
                )
        );

        ResponseEnvelope<RecipeOutputDTO> response = new ResponseEnvelope<>(LocalDateTime.now(),
                output, "Receita atualizada com sucesso!");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseEnvelope<String>> delete(@PathVariable Long id){
        deleteRecipeUseCase.execute(id);

        ResponseEnvelope<String> response = new ResponseEnvelope<>(LocalDateTime.now(),
                null, null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
