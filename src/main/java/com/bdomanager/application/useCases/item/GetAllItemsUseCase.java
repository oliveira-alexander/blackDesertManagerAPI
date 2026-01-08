package com.bdomanager.application.useCases.item;

import com.bdomanager.domain.item.model.Item;

import java.util.List;

public interface GetAllItemsUseCase {
    List<Item> execute();
}
