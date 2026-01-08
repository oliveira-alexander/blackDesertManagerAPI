package com.bdomanager.infrastructure.adapt.repositories.impl;

import com.bdomanager.domain.recipe.model.RecipeModel;
import com.bdomanager.application.recipe.adapters.repository.RecipeRepository;
import com.bdomanager.infrastructure.adapt.repositories.ItemJPARepository;
import com.bdomanager.infrastructure.adapt.repositories.RecipeItemJPARepository;
import com.bdomanager.infrastructure.adapt.repositories.RecipeJPARepository;
import com.bdomanager.infrastructure.entities.ItemEntity;
import com.bdomanager.infrastructure.entities.RecipeEntity;
import com.bdomanager.infrastructure.entities.RecipeItemEntity;
import com.bdomanager.utils.mappers.ItemMapper;
import com.bdomanager.utils.mappers.RecipeMapper;
import org.springframework.stereotype.Repository;

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
                            .map(RecipeMapper::recipeEntityToRecipeModel)
                            .toList();
    }

    @Override
    public RecipeModel getById(Long id) {
        return RecipeMapper.recipeEntityToRecipeModel(recipeRepository.findById(id).get());
    }

    @Override
    public RecipeModel create(RecipeModel recipeModel) {
        RecipeEntity entity = RecipeMapper.recipeModelToRecipeEntity(recipeModel);
        recipeRepository.save(entity);

        recipeModel.getItems().stream()
                .forEach(item -> {
                    ItemEntity itemEntity = ItemMapper.itemToItemEntity(item.getItem());

                    RecipeItemEntity recipeItem = new RecipeItemEntity(entity, itemEntity, item.getQuantity());
                    recipeItemRepository.save(recipeItem);
                });

        return RecipeMapper.recipeEntityToRecipeModel(entity);
    }

    @Override
    public RecipeModel update(RecipeModel recipeModel) {
        RecipeEntity updatingRecipe = RecipeMapper.recipeModelToRecipeEntity(recipeModel);
        recipeRepository.save(updatingRecipe);
        return RecipeMapper.recipeEntityToRecipeModel(updatingRecipe);
    }

    @Override
    public void delete(Long id) {
        recipeRepository.deleteById(id);
        recipeItemRepository.deleteRecipeItems(id);
    }
}
