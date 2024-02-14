package com.programmingdevesh.inventoryservice.controller;

import com.programmingdevesh.inventoryservice.CustomExceptions.ItemNotFoundException;
import com.programmingdevesh.inventoryservice.dto.InventoryItemDTO;
import com.programmingdevesh.inventoryservice.dto.InventoryItemResponse;
import com.programmingdevesh.inventoryservice.service.InventoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inv")
public class InventoryController {

    Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @Autowired
    public InventoryController(InventoryServiceImpl inventoryServiceImpl) {
        this.inventoryServiceImpl = inventoryServiceImpl;
    }

    @GetMapping("/{itemName}")
    public ResponseEntity<InventoryItemDTO> fetchInventoryItemByitemName(@PathVariable String itemName) throws ItemNotFoundException {
        logger.info("Inside InventoryController. Fetching Inventory Item By itemName started.");
      try{
          InventoryItemDTO inventoryItemDTO = inventoryServiceImpl.fetchItemByItemName(itemName);
          return new ResponseEntity<>(inventoryItemDTO, HttpStatus.OK);
      }catch (ItemNotFoundException itemNotFoundException){
            throw itemNotFoundException;
      }finally {
          logger.info("Inside InventoryController. Fetching Inventory Item By itemName ended.");
      }
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventoryItemDTO>> fetchAllInventoryItems(){
        logger.info("Inside InventoryController. Fetching all Inventory Items started.");
         try
         {
             List<InventoryItemDTO> inventoryItemDTOList = inventoryServiceImpl.fetchAllInventoryItems();
             return new ResponseEntity<>(inventoryItemDTOList, HttpStatus.OK);
         }finally {
             logger.info("Inside InventoryController. Fetching all Inventory Items ended.");
         }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //http://localhost:8080/api/inv?itemNames=Laptop,Phone
    public List<InventoryItemResponse> checkIfItemsExistInInventory
            (@RequestParam(value = "itemNames") List<String> itemNameList){
        return inventoryServiceImpl.checkIfItemsExistInInventory(itemNameList);
    }


}
