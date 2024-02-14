package com.programmingdevesh.inventoryservice.service;

import com.programmingdevesh.inventoryservice.CustomExceptions.ItemNotFoundException;
import com.programmingdevesh.inventoryservice.dto.InventoryItemDTO;
import com.programmingdevesh.inventoryservice.dto.InventoryItemResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryService {
    InventoryItemDTO fetchItemByItemName(String itemName) throws ItemNotFoundException;

    List<InventoryItemDTO> fetchAllInventoryItems();

    @Transactional(readOnly = true)
    List<InventoryItemResponse> checkIfItemsExistInInventory(List<String> itemNameList);
}
