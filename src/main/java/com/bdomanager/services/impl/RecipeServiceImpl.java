package com.bdomanager.services.impl;

import com.bdomanager.dtos.recipe.RecipeInputDTO;
import com.bdomanager.dtos.recipe.RecipeOutputDTO;
import com.bdomanager.dtos.recipeItem.RecipeItemOutputDTO;
import com.bdomanager.entities.Recipe;
import com.bdomanager.repositories.RecipeRepository;
import com.bdomanager.services.RecipeItemService;
import com.bdomanager.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeItemService recipeItemService;

    @Override
    public List<RecipeOutputDTO> getAll() {
        List<Recipe> recipesDB = recipeRepository.findAll();
        List<RecipeOutputDTO> recipesResponse = new ArrayList<>();

        recipesDB.stream().forEach(recipe -> {
            recipesResponse.add(new RecipeOutputDTO(recipe.getId(),
                                                    recipe.getDescription(),
                                                    null));
        });

        return recipesResponse;
    }

    @Override
    public RecipeOutputDTO getById(Long id) {
        Recipe recipe = recipeRepository.findById(id).get();

        RecipeOutputDTO response = new RecipeOutputDTO(recipe.getId(),
                                                       recipe.getDescription(),
                                                       Optional.of(recipeItemService.getRecipeItems(id)));

        return response;
    }

    @Override
    public RecipeOutputDTO create(RecipeInputDTO newRecipe) {
        Recipe recipe = recipeRepository.save(new Recipe(newRecipe.description()));

        newRecipe.items().get().stream().forEach(recipeItem -> {
            recipeItemService.addItem(recipe.getId(), recipeItem);
        });

        return new RecipeOutputDTO(recipe.getId(),
                                   recipe.getDescription(),
                                   null);
    }

    @Override
    public RecipeOutputDTO update(RecipeInputDTO updatingRecipe) {
        Recipe recipe = recipeRepository.findById(updatingRecipe.id().get()).get();

        recipeItemService.updateItems(recipe.getId(), updatingRecipe.items().get());
        recipe.setDescription(updatingRecipe.description());
        recipeRepository.save(recipe);

        return new RecipeOutputDTO(recipe.getId(),
                                   recipe.getDescription(),
                                   null);
    }

    @Override
    public void delete(Long id) {
        if (recipeRepository.existsById((id))) {
            if (recipeRepository.getCountRecipeItems(id) > 0)
                recipeRepository.deleteRecipeItems(id);

            recipeRepository.deleteById(id);
        }
    }
}
