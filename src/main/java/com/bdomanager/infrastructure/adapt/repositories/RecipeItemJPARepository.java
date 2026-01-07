package com.bdomanager.infrastructure.adapt.repositories;

import com.bdomanager.infrastructure.entities.RecipeItemEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeItemJPARepository extends JpaRepository<RecipeItemEntity, Long> {

    @Query(value = "SELECT * FROM recipe_items WHERE recipe_id = :recipeId", nativeQuery = true)
    List<RecipeItemEntity> getRecipeItemsByRecipe(@Param("recipeId") Long recipeId);

    boolean existsByItemIdAndRecipeId(Long itemId, Long recipeId);

    @Query(value = "SELECT * FROM recipe_items WHERE recipe_id = :recipeId AND item_id = :itemId", nativeQuery = true)
    RecipeItemEntity getRecipeItemByRecipeAndItem(@Param("recipeId") Long recipeId, @Param("itemId") Long itemId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM recipe_items WHERE recipe_id = :recipeId AND item_id not in :itemsArray", nativeQuery = true)
    void deleteUnusedRecipeItems(@Param("recipeId") Long recipeId, @Param("itemsArray") List<Long> itemsArray);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM recipe_items WHERE recipe_id = :recipeId", nativeQuery = true)
    void deleteRecipeItems(@Param("recipeId") Long recipeId);

    @Query(value = "SELECT COUNT(item_id) FROM recipe_items WHERE recipe_id = :recipeId AND item_id not in :itemsArray", nativeQuery = true)
    int getCountUnusedRecipeItems(@Param("recipeId") Long recipeId, @Param("itemsArray") List<Long> itemsArray);
}
