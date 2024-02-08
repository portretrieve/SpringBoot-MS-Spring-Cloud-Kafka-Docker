package com.programmingdevesh.inventoryservice.repository;

import com.programmingdevesh.inventoryservice.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> findInventoryItemsBySkuCodeIn(List<String> skuCodeList);
}
