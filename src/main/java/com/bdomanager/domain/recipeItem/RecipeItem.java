package com.bdomanager.domain.recipeItem;

public class RecipeItem {
    private Long id;
    private Long idItem;
    private int quantity;

    public RecipeItem(Long id,
                      Long idItem,
                      int quantity){
        this.id = id;
        this.idItem = idItem;
        this.quantity = quantity;
    }


    public RecipeItem(Long idItem,
                      int quantity){
        this.idItem = idItem;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }
}
