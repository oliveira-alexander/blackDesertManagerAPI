package com.bdomanager.application.useCases.item;

import com.bdomanager.domain.item.model.Item;

public interface GetItemByIdUseCase {
    Item execute(Long id);
}
