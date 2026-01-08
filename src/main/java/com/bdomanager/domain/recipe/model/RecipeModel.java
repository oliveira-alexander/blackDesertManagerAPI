package com.bdomanager.domain.recipe.model;

import com.bdomanager.domain.recipeItem.model.RecipeItemModel;

import java.util.List;

public class RecipeModel {
    private Long id;
    private String description;
    private List<RecipeItemModel> items;

    public RecipeModel(Long id,
                       String description,
                       List<RecipeItemModel> items)
    {
        this.id = id;
        this.description = description;
        this.items = items;
    }

    public RecipeModel(String description,
                       List<RecipeItemModel> items)
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

    public List<RecipeItemModel> getItems() {
        return items;
    }

    public void setItems(List<RecipeItemModel> items) {
        this.items = items;
    }
}
