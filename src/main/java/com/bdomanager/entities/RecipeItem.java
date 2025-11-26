package com.bdomanager.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RecipeItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    private Recipe recipe;

    private int quantity;

    public RecipeItem(Recipe recipe,
                      Item item,
                      int quantity){
        this.item = item;
        this.recipe = recipe;
        this.quantity = quantity;
    }
}
