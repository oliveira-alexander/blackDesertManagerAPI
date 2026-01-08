package com.bdomanager.Infrastructure.recipeItem.entity;

import com.bdomanager.Infrastructure.item.entity.ItemEntity;
import com.bdomanager.Infrastructure.recipe.entity.RecipeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RecipeItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id", nullable = false)
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    private RecipeEntity recipe;

    private int quantity;

    public RecipeItemEntity(RecipeEntity recipeEntity,
                            ItemEntity item,
                            int quantity){
        this.item = item;
        this.recipe = recipeEntity;
        this.quantity = quantity;
    }
}
