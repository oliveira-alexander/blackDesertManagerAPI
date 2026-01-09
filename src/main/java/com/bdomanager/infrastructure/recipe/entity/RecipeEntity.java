package com.bdomanager.infrastructure.recipe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Recipes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ElementCollection
    @CollectionTable(
            name = "recipe_item",
            joinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<RecipeItemEmbeddable> items = new ArrayList<>();

    public RecipeEntity(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public RecipeEntity(String description, List<RecipeItemEmbeddable> items){
        this.description = description;
        this.items = items;
    }

}
