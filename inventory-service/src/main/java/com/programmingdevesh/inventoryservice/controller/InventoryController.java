package com.programmingdevesh.inventoryservice.controller;

import com.programmingdevesh.inventoryservice.CustomExceptions.ItemNotFoundException;
import com.programmingdevesh.inventoryservice.dto.InventoryItemDTO;
import com.programmingdevesh.inventoryservice.dto.InventoryItemResponse;
import com.programmingdevesh.inventoryservice.model.InventoryItem;
import com.programmingdevesh.inventoryservice.repository.InventoryRepository;
import com.programmingdevesh.inventoryservice.service.InventoryService;
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
    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String testServerTwo(){
        logger.info("Inside Inventory Controller Test Server Method.");
        return "Inventory Service is running : TEST";
    }


    @GetMapping("/{itemName}")
    public ResponseEntity<InventoryItemDTO> fetchInventoryItemByitemName(@PathVariable String itemName) throws ItemNotFoundException {
        logger.info("Inside InventoryController. Fetching Inventory Item By itemName started.");
      try{
          InventoryItemDTO inventoryItemDTO = inventoryService.fetchItemByItemName(itemName);
          return new ResponseEntity<>(inventoryItemDTO, HttpStatus.OK);
      }catch (ItemNotFoundException itemNotFoundException){
            throw itemNotFoundException;
      }finally {
          logger.info("Inside InventoryController. Fetching Inventory Item By itemName ended.");
      }
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventoryItemDTO>> fetchAllInventoryItems(){
        List<InventoryItemDTO> inventoryItemDTOList = inventoryService.fetchAllInventoryItems();
        return new ResponseEntity<>(inventoryItemDTOList, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //http://localhost:8080/api/inv?itemNames=Laptop,Phone
    public List<InventoryItemResponse> checkIfItemsExistInInventory
            (@RequestParam(value = "itemNames") List<String> itemNameList){
        return inventoryService.checkIfItemsExistInInventory(itemNameList);
    }


}
