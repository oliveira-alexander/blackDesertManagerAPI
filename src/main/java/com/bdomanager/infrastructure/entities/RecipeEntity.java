package com.bdomanager.infrastructure.entities;

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
