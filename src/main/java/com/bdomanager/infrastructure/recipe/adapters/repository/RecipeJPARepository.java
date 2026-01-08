package com.bdomanager.Infrastructure.recipe.adapters.repository;

import com.bdomanager.Infrastructure.recipe.entity.RecipeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeJPARepository extends JpaRepository<RecipeEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM recipe_items WHERE recipe_id = :recipeId", nativeQuery = true)
    void deleteRecipeItems(@Param("recipeId") Long recipeId);

    @Query(value = "SELECT COUNT(recipe_id) FROM recipe_items WHERE recipe_id = :recipeId", nativeQuery = true)
    int getCountRecipeItems(@Param("recipeId") Long recipeId);
}
