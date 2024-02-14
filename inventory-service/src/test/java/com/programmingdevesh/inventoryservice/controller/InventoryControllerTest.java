package com.programmingdevesh.inventoryservice.controller;

import com.programmingdevesh.inventoryservice.CustomExceptions.ItemNotFoundException;
import com.programmingdevesh.inventoryservice.dto.InventoryItemDTO;
import com.programmingdevesh.inventoryservice.service.InventoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.times;

class InventoryControllerTest {

    @InjectMocks
    private InventoryController inventoryController;

    @Mock
    private InventoryServiceImpl inventoryServiceImpl;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchInventoryItemByItemName() throws ItemNotFoundException {
        String itemName = "Laptop";
        InventoryItemDTO inventoryItemDTO = new InventoryItemDTO("Laptop", 10);
        Mockito.when(inventoryServiceImpl.fetchItemByItemName(itemName)).thenReturn(inventoryItemDTO);
        InventoryItemDTO result = inventoryController.fetchInventoryItemByItemName(itemName).getBody();
        Assertions.assertEquals(inventoryItemDTO, result);
        Mockito.verify(inventoryServiceImpl, times(1)).fetchItemByItemName(itemName);
    }

    @Test
    void fetchAllInventoryItems() {
        List<InventoryItemDTO> inventoryItemDTOList = List.of(new InventoryItemDTO("Laptop", 10));
        Mockito.when(inventoryServiceImpl.fetchAllInventoryItems()).thenReturn(inventoryItemDTOList);
        var result = inventoryController.fetchAllInventoryItems().getBody();
        Assertions.assertEquals(inventoryItemDTOList, result);
        Mockito.verify(inventoryServiceImpl, times(1)).fetchAllInventoryItems();
    }

}