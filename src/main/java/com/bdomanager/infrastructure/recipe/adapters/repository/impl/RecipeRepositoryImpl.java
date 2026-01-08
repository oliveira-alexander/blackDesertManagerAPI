package com.bdomanager.Infrastructure.recipe.adapters.repository.impl;

import com.bdomanager.Infrastructure.recipe.mapper.RecipeInfrastructureMapper;
import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.Infrastructure.item.adapters.repository.ItemJPARepository;
import com.bdomanager.Infrastructure.recipeItem.adapters.repository.RecipeItemJPARepository;
import com.bdomanager.Infrastructure.recipe.adapters.repository.RecipeJPARepository;
import com.bdomanager.Infrastructure.item.entity.ItemEntity;
import com.bdomanager.Infrastructure.recipe.entity.RecipeEntity;
import com.bdomanager.Infrastructure.recipeItem.entity.RecipeItemEntity;
import com.bdomanager.domain.recipeItem.model.RecipeItemModel;
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
    public List<RecipeModel> getAll() {
        List<RecipeEntity> recipesEntity = recipeRepository.findAll();

        return recipesEntity.stream()
                            .map(RecipeInfrastructureMapper::entityToModel)
                            .toList();
    }

    @Override
    public RecipeModel getById(Long id) {
        return RecipeInfrastructureMapper.entityToModel(recipeRepository.findById(id).get());
    }

    @Override
    public RecipeModel create(RecipeModel recipeModel) { // Id, description e items (recipeItemsModel)
        RecipeEntity recipe = new RecipeEntity(recipeModel.getDescription());
        recipeRepository.save(recipe);

        List<RecipeItemModel> recipeItemsModel = new ArrayList<>();

        recipeModel.getItems().stream().forEach(item -> {
            
            ItemEntity itemEntity = itemRepository.findById(item.getIdItem()).get();

            RecipeItemEntity recipeItem = new RecipeItemEntity(recipe, itemEntity, item.getQuantity());

            recipeItemRepository.save(recipeItem);

            recipeItemsModel.add(new RecipeItemModel(recipeItem.getId(), recipeItem.getQuantity()));
        });

        return new RecipeModel(recipe.getId(), recipe.getDescription(), recipeItemsModel);
    }

    @Override
    public RecipeModel update(RecipeModel recipeModel) {
        RecipeEntity recipe = new RecipeEntity(recipeModel.getId(), recipeModel.getDescription());
        recipeRepository.save(recipe);

        List<RecipeItemModel> recipeItemsModel = new ArrayList<>();

        recipeModel.getItems().stream().forEach(item -> {
            ItemEntity itemEntity = itemRepository.findById(item.getId()).get();

            RecipeItemEntity recipeItem = new RecipeItemEntity(recipe, itemEntity, item.getQuantity());

            recipeItemRepository.save(recipeItem);

            recipeItemsModel.add(new RecipeItemModel(recipeItem.getId(), recipeItem.getQuantity()));
        });

        return new RecipeModel(recipe.getId(), recipe.getDescription(), recipeItemsModel);
    }

    @Override
    public void delete(Long id) {
        recipeRepository.deleteById(id);
        recipeItemRepository.deleteRecipeItems(id);
    }
}
