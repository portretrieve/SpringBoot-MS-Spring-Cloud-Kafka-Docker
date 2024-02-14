package com.programmingdevesh.inventoryservice.service;

import com.programmingdevesh.inventoryservice.CustomExceptions.ItemNotFoundException;
import com.programmingdevesh.inventoryservice.dto.InventoryItemDTO;
import com.programmingdevesh.inventoryservice.entity.InventoryItem;
import com.programmingdevesh.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.times;

public class InventoryServiceImplTest {

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @Mock
    private InventoryRepository inventoryRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void fetchItemByItemNameTest() throws ItemNotFoundException {
        String itemName = "Laptop";
        InventoryItem inventoryItem = new InventoryItem(1L, "Laptop", 10);
        InventoryItemDTO inventoryItemDTO = new InventoryItemDTO("Laptop", 10);
        Mockito.when(inventoryRepository.findByItemName(itemName)).thenReturn(Optional.of(inventoryItem));
        InventoryItemDTO result = inventoryService.fetchItemByItemName(itemName);
        Assertions.assertEquals(inventoryItemDTO, result);
        Mockito.verify(inventoryRepository, times(1)).findByItemName(itemName);
    }


}
