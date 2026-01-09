package com.bdomanager.infrastructure.recipe.adapters.repository.impl;

import com.bdomanager.infrastructure.recipe.entity.RecipeItemEmbeddable;
import com.bdomanager.infrastructure.recipe.mapper.RecipeInfrastructureMapper;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.infrastructure.item.adapters.repository.ItemJPARepository;
import com.bdomanager.infrastructure.recipe.adapters.repository.RecipeJPARepository;
import com.bdomanager.infrastructure.recipe.entity.RecipeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private RecipeJPARepository recipeRepository;
    private ItemJPARepository itemRepository;

    public RecipeRepositoryImpl(RecipeJPARepository recipeRepository,
                                ItemJPARepository itemRepository){
        this.itemRepository = itemRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAll() {
        List<RecipeEntity> recipesEntity = recipeRepository.findAll();

        return recipesEntity.stream()
                            .map(RecipeInfrastructureMapper::entityToModel)
                            .toList();
    }

    @Override
    public Recipe getById(Long id) {
        return RecipeInfrastructureMapper.entityToModel(recipeRepository.findById(id).get());
    }

    @Override
    public Recipe create(Recipe recipeModel) { // Id, description e items (recipeItemsModel)
        List<RecipeItemEmbeddable> items = new ArrayList<>();

        recipeModel.getItems().forEach(item -> items.add(new RecipeItemEmbeddable(item.getIdItem(), item.getQuantity())));

        RecipeEntity recipe = new RecipeEntity(recipeModel.getDescription(), items);
        recipeRepository.save(recipe);
        return new Recipe(recipe.getId(), recipe.getDescription(), recipeModel.getItems());
    }

    @Override
    public Recipe update(Recipe recipeModel) {
        List<RecipeItemEmbeddable> items = new ArrayList<>();

        recipeModel.getItems().forEach(item -> items.add(new RecipeItemEmbeddable(item.getIdItem(), item.getQuantity())));

        RecipeEntity recipe = new RecipeEntity(recipeModel.getDescription(), items);
        recipeRepository.save(recipe);
        return new Recipe(recipe.getId(), recipe.getDescription(), recipeModel.getItems());
    }

    @Override
    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }
}
