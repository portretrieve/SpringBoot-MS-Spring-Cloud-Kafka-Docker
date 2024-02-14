package com.programmingdevesh.inventoryservice.repository;

import com.programmingdevesh.inventoryservice.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> findInventoryItemsByItemNameIn(List<String> itemNamesList);

    Optional<InventoryItem> findByItemName(String itemName);
}
