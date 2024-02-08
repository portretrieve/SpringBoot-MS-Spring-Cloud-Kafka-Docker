package com.programmingdevesh.inventoryservice.controller;

import com.programmingdevesh.inventoryservice.dto.InventoryItemResponse;
import com.programmingdevesh.inventoryservice.model.InventoryItem;
import com.programmingdevesh.inventoryservice.repository.InventoryRepository;
import com.programmingdevesh.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inv")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String testServerTwo(){
        return "Inventory Service is running : TEST";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //http://localhost:8080/api/inv?skuCode=Laptop
    public List<InventoryItemResponse> areItemsInInventory(@RequestParam(value = "skuCode") List<String> skuCodeList){
        return inventoryService.areItemsInInventory(skuCodeList);
    }

    @GetMapping("/all")
    public List<InventoryItem> getAllInventoryItems(){
        return inventoryRepository.findAll();
    }
}
