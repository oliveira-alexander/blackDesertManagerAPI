package com.bdomanager.domain.recipeItem.model;

import com.bdomanager.domain.item.model.ItemModel;

public class RecipeItemModel {
    private Long id;
    private ItemModel itemModel;
    private int quantity;

    public RecipeItemModel(Long id,
                           ItemModel itemModel,
                           int quantity){
        this.id = id;
        this.itemModel = itemModel;
        this.quantity = quantity;
    }


    public RecipeItemModel(ItemModel itemModel,
                           int quantity){
        this.itemModel = itemModel;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemModel getItem() {
        return itemModel;
    }

    public void setItem(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
