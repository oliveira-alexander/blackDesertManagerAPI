package com.bdomanager.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private Long id;
    private String description;
    private List<RecipeItem> items = new ArrayList<>();

    public Recipe(Long id,
                  String description,
                  List<RecipeItem> items)
    {
        this.id = id;
        this.description = description;
        this.items = items;
    }

    public Recipe(String description,
                  List<RecipeItem> items)
    {
        this.description = description;
        this.items = items;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RecipeItem> getItems() {
        return items;
    }

    public void setItems(List<RecipeItem> items) {
        this.items = items;
    }
}
