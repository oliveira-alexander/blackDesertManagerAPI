package com.bdomanager.application.commands.item;

public record UpdateItemCommand(Long id,
                                String description,
                                float marketPrice,
                                float productionCost) {
}
