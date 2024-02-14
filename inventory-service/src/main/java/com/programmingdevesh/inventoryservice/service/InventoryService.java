package com.programmingdevesh.inventoryservice.service;

import com.programmingdevesh.inventoryservice.CustomExceptions.ItemNotFoundException;
import com.programmingdevesh.inventoryservice.dto.InventoryItemDTO;
import com.programmingdevesh.inventoryservice.dto.InventoryItemResponse;
import com.programmingdevesh.inventoryservice.model.InventoryItem;
import com.programmingdevesh.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryItemDTO fetchItemByItemName(String itemName) throws ItemNotFoundException {

        Optional<InventoryItem> optionalInventoryItem = inventoryRepository.findByItemName(itemName);
        return optionalInventoryItem.map(inventoryItem -> mapInventoryItemToInventoryItemDTO(inventoryItem))
                .orElseThrow(()->new ItemNotFoundException("Item doen't exist with this ItemName: " + itemName));
    }

    public List<InventoryItemDTO> fetchAllInventoryItems(){
        return inventoryRepository.findAll().stream()
                .map(this::mapInventoryItemToInventoryItemDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InventoryItemResponse> checkIfItemsExistInInventory(List<String> itemNameList){
        return inventoryRepository.findInventoryItemsByItemNameIn(itemNameList).stream()
                .map(inventoryItem -> InventoryItemResponse.builder().itemName(inventoryItem.getItemName())
                        .isInStock(inventoryItem.getQuantity() > 0).build())
                .toList();
    }

    private InventoryItemDTO mapInventoryItemToInventoryItemDTO(InventoryItem inventoryItem){
        return new InventoryItemDTO(inventoryItem.getItemName(), inventoryItem.getQuantity());
    }

    private InventoryItemResponse mapInventoryItemToInventoryItemResponse(InventoryItem inventoryItem){
        InventoryItemResponse inventoryItemResponse = new InventoryItemResponse();
        inventoryItemResponse.setItemName(inventoryItem.getItemName());
        inventoryItemResponse.setInStock(inventoryItem.getQuantity() > 0);
        return inventoryItemResponse;
    }
}
