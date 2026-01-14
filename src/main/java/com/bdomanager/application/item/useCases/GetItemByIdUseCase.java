package com.bdomanager.application.item.useCases;

import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.domain.item.Item;

public interface GetItemByIdUseCase {
    ItemOutputDTO execute(Long id);
}
