package com.bdomanager.application.item.commands;

public record CreateItemCommand(String description,
                                float marketPrice,
                                float productionCost) {
}
