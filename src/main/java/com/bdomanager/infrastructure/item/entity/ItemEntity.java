package com.bdomanager.infrastructure.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Items")
@NoArgsConstructor
@Getter
@Setter
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private float marketPrice;

    private float productionCost;

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
