package com.bdomanager.application.item.useCases;

import com.bdomanager.domain.item.Item;

import java.util.List;

public interface GetAllItemsUseCase {
    List<Item> execute();
}
