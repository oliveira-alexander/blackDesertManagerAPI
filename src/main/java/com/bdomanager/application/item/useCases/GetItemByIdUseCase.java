package com.bdomanager.application.item.useCases;

import com.bdomanager.domain.item.model.ItemModel;

public interface GetItemByIdUseCase {
    ItemModel execute(Long id);
}
