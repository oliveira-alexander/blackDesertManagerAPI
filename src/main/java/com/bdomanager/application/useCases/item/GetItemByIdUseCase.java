package com.bdomanager.application.useCases.item;

import com.bdomanager.domain.models.Item;

public interface GetItemByIdUseCase {
    Item execute(Long id);
}
