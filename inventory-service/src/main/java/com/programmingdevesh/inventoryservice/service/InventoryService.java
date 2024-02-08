package com.programmingdevesh.inventoryservice.service;

import com.programmingdevesh.inventoryservice.dto.InventoryItemResponse;
import com.programmingdevesh.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryItemResponse> areItemsInInventory(List<String> skuCodeList){
        return inventoryRepository.findInventoryItemsBySkuCodeIn(skuCodeList).stream()
                //.map(inventoryItem -> new InventoryItemResponse(inventoryItem.getSkuCode(), inventoryItem.getQuantity() > 0)).toList();
                //Or
                .map(inventoryItem -> InventoryItemResponse.builder()
                        .skuCode(inventoryItem.getSkuCode()).isInStock(inventoryItem.getQuantity() > 0).build())
                .toList();
    }
}
