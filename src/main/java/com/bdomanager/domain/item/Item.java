package com.bdomanager.domain.item;

public class Item {
    private Long id;
    private String description;
    private float marketPrice;
    private float productionCost;

    // Constructors

        public Item(String description,
                    float marketPrice,
                    float productionCost){
            this.description = description;
            this.marketPrice = marketPrice;
            this.productionCost = productionCost;
        }

        public Item(Long id,
                    String description,
                    float marketPrice,
                    float productionCost) {
            this.id = id;
            this.description = description;
            this.marketPrice = marketPrice;
            this.productionCost = productionCost;
        }

    // Getters & Setters

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

        public float getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(float marketPrice) {
            this.marketPrice = marketPrice;
        }

        public float getProductionCost() {
            return productionCost;
        }

        public void setProductionCost(float productionCost) {
            this.productionCost = productionCost;
        }
}
