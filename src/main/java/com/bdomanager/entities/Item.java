package com.bdomanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private float marketPrice;

    private float productionCost;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<RecipeItem> items = new ArrayList<>();

    public Item(String description,
                float marketPrice,
                float productionCost){
        this.description = description;
        this.marketPrice = marketPrice;
        this.productionCost = productionCost;
    }
}
