package com.bdomanager.application.item.useCases;

import com.bdomanager.domain.item.model.ItemModel;

import java.util.List;

public interface GetAllItemsUseCase {
    List<ItemModel> execute();
}
