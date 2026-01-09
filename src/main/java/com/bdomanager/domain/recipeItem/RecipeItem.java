package com.bdomanager.domain.recipeItem;

public class RecipeItem {
    private Long idItem;
    private int quantity;

    // Constructors

        public RecipeItem(Long idItem,
                          int quantity){
            this.idItem = idItem;
            this.quantity = quantity;
        }

    // Getters & Setters

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
