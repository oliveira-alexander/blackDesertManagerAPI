package com.bdomanager.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private float marketPrice;

    private float productionCost;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<RecipeItemEntity> items = new ArrayList<>();

    public ItemEntity(String description,
                      float marketPrice,
                      float productionCost){
        this.description = description;
        this.marketPrice = marketPrice;
        this.productionCost = productionCost;
    }

    public ItemEntity(Long id,
                      String description,
                      float marketPrice,
                      float productionCost){
        this.id = id;
        this.description = description;
        this.marketPrice = marketPrice;
        this.productionCost = productionCost;
    }
}
