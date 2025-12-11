package com.bdomanager.application.commands.item;

public record CreateItemCommand(String description,
                                float marketPrice,
                                float productionCost) {
}
