package com.bdomanager.infrastructure.recipe.adapters.repository.impl;

import com.bdomanager.infrastructure.recipe.mapper.RecipeInfrastructureMapper;
import com.bdomanager.domain.recipe.Recipe;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.infrastructure.item.adapters.repository.ItemJPARepository;
import com.bdomanager.infrastructure.recipeItem.adapters.repository.RecipeItemJPARepository;
import com.bdomanager.infrastructure.recipe.adapters.repository.RecipeJPARepository;
import com.bdomanager.infrastructure.item.entity.ItemEntity;
import com.bdomanager.infrastructure.recipe.entity.RecipeEntity;
import com.bdomanager.infrastructure.recipeItem.entity.RecipeItemEntity;
import com.bdomanager.domain.recipeItem.RecipeItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private RecipeItemJPARepository recipeItemRepository;
    private RecipeJPARepository recipeRepository;
    private ItemJPARepository itemRepository;

    public RecipeRepositoryImpl(RecipeItemJPARepository recipeItemRepository,
                                RecipeJPARepository recipeRepository,
                                ItemJPARepository itemRepository){
        this.itemRepository = itemRepository;
        this.recipeRepository = recipeRepository;
        this.recipeItemRepository = recipeItemRepository;
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
        RecipeEntity recipe = new RecipeEntity(recipeModel.getDescription());
        recipeRepository.save(recipe);

        List<RecipeItem> recipeItemsModel = new ArrayList<>();

        recipeModel.getItems().stream().forEach(item -> {

            ItemEntity itemEntity = itemRepository.findById(item.getIdItem()).get();

            RecipeItemEntity recipeItem = new RecipeItemEntity(recipe, itemEntity, item.getQuantity());

            recipeItemRepository.save(recipeItem);

            recipeItemsModel.add(new RecipeItem(recipeItem.getId(), recipeItem.getQuantity()));
        });

        return new Recipe(recipe.getId(), recipe.getDescription(), recipeItemsModel);
    }

    @Override
    public Recipe update(Recipe recipeModel) {
        RecipeEntity recipe = new RecipeEntity(recipeModel.getId(), recipeModel.getDescription());
        recipeRepository.save(recipe);

        List<RecipeItem> recipeItemsModel = new ArrayList<>();

        recipeModel.getItems().stream().forEach(item -> {
            ItemEntity itemEntity = itemRepository.findById(item.getId()).get();

            RecipeItemEntity recipeItem = new RecipeItemEntity(recipe, itemEntity, item.getQuantity());

            recipeItemRepository.save(recipeItem);

            recipeItemsModel.add(new RecipeItem(recipeItem.getId(), recipeItem.getQuantity()));
        });

        return new Recipe(recipe.getId(), recipe.getDescription(), recipeItemsModel);
    }

    @Override
    public void delete(Long id) {
        recipeRepository.deleteById(id);
        recipeItemRepository.deleteRecipeItems(id);
    }
}
