package com.bdomanager.infrastructure.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class RecipeItemEmbeddable {

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private int quantity;

    // Constructors

        public RecipeItemEmbeddable(Long itemId,
                                    int quantity){
            this.itemId = itemId;
            this.quantity = quantity;
        }
}
