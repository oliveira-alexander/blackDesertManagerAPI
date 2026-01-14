package com.bdomanager.application.item.useCases;

import com.bdomanager.application.item.dtos.ItemOutputDTO;
import com.bdomanager.domain.item.Item;

import java.util.List;

public interface GetAllItemsUseCase {
    List<ItemOutputDTO> execute();
}
