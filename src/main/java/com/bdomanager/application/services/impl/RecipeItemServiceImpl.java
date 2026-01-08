package com.bdomanager.application.services.impl;

import com.bdomanager.infrastructure.dtos.recipeItem.RecipeItemInputDTO;
import com.bdomanager.infrastructure.dtos.recipeItem.RecipeItemOutputDTO;
import com.bdomanager.application.services.RecipeItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeItemServiceImpl implements RecipeItemService {

//    @Autowired
//    private RecipeItemRepository recipeItemRepository;
//
//    @Autowired
//    private RecipeRepository recipeRepository;
//
//    @Autowired
//    private ItemRepository itemRepository;

    @Override
    public void addItem(Long recipeId, RecipeItemInputDTO recipeItem) {
//        Recipe recipe = recipeRepository.findById(recipeId).get();
//        Item itemDb = itemRepository.findById(recipeItem.itemId()).get();
//
//        RecipeItem recipeItemDB = new RecipeItem(recipe,
//                                                 itemDb,
//                                                 recipeItem.quantity());
//
//        recipeItemRepository.save(recipeItemDB);
    }

    @Override
    public void updateItems(Long recipeId, List<RecipeItemInputDTO> recipeItems) {
//        Recipe recipe = recipeRepository.findById(recipeId).get();
//        List<Long> itemsId = new ArrayList<>();
//
//        recipeItemRepository.deleteUnusedRecipeItems(recipeId, itemsId);
//
//        recipeItems.stream().forEach(item -> {
//            Item itemDb = itemRepository.findById(item.itemId()).get();
//            itemsId.add(item.itemId());
//
//            RecipeItem recipeItemDB = new RecipeItem(recipe,
//                    itemDb,
//                    item.quantity());
//
//            if (recipeItemRepository.existsByItemIdAndRecipeId(recipeItemDB.getRecipe().getId(),
//                                                               recipeItemDB.getItem().getId())){
//
//                RecipeItem recipeItemOld =
//                        recipeItemRepository.getRecipeItemByRecipeAndItem(recipeItemDB.getRecipe().getId(),
//                                                                          recipeItemDB.getItem().getId());
//
//                recipeItemOld.setQuantity(item.quantity());
//
//                recipeItemRepository.save(recipeItemOld);
//            }
//            else
//                recipeItemRepository.save(recipeItemDB);
//        });
    }

    @Override
    public List<RecipeItemOutputDTO> getRecipeItems(Long recipeId) {
        return null;
//        List<RecipeItem> recipeItems = recipeItemRepository.getRecipeItemsByRecipe(recipeId);
//        List<RecipeItemOutputDTO> recipeItemsResponse = new ArrayList<>();
//
//        recipeItems.stream().forEach(recipeItem -> {
//            recipeItemsResponse.add(new RecipeItemOutputDTO(recipeItem.getItem(),
//                                                            recipeItem.getQuantity()));
//        });
//
//        return recipeItemsResponse;
    }
}
