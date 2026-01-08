package com.bdomanager.application.item.useCases;

import com.bdomanager.domain.item.Item;

public interface GetItemByIdUseCase {
    Item execute(Long id);
}
