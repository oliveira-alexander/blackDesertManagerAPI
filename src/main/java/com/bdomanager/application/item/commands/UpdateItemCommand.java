package com.bdomanager.application.item.commands;

public record UpdateItemCommand(Long id,
                                String description,
                                float marketPrice,
                                float productionCost) {
}
