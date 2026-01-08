package com.bdomanager.Infrastructure.recipe.entity;

import com.bdomanager.Infrastructure.recipeItem.entity.RecipeItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

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

    @Lazy
    @OneToMany(mappedBy = "recipe")
    private List<RecipeItemEntity> items = new ArrayList<>();

    public RecipeEntity(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public RecipeEntity(String description){
        this.description = description;
    }
}
