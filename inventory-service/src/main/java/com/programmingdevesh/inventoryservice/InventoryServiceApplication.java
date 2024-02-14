package com.programmingdevesh.inventoryservice;

import com.programmingdevesh.inventoryservice.entity.InventoryItem;
import com.programmingdevesh.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			InventoryItem inventoryItem1 = new InventoryItem();
			inventoryItem1.setItemName("Phone");
			inventoryItem1.setQuantity(100);

			InventoryItem inventoryItem2 = new InventoryItem();
			inventoryItem2.setItemName("Laptop");
			inventoryItem2.setQuantity(50);

			InventoryItem inventoryItem3 = new InventoryItem();
			inventoryItem3.setItemName("Desktop");
			inventoryItem3.setQuantity(75);

			InventoryItem inventoryItem4 = new InventoryItem();
			inventoryItem4.setItemName("Speeker");
			inventoryItem4.setQuantity(500);

			InventoryItem inventoryItem5 = new InventoryItem();
			inventoryItem5.setItemName("Earbud");
			inventoryItem5.setQuantity(1000);

			InventoryItem inventoryItem6 = new InventoryItem();
			inventoryItem6.setItemName("Monitor");
			inventoryItem6.setQuantity(250);

			InventoryItem inventoryItem7 = new InventoryItem();
			inventoryItem7.setItemName("Hard Disk");
			inventoryItem7.setQuantity(300);

			inventoryRepository.save(inventoryItem1);
			inventoryRepository.save(inventoryItem2);
			inventoryRepository.save(inventoryItem3);
			inventoryRepository.save(inventoryItem4);
			inventoryRepository.save(inventoryItem5);
			inventoryRepository.save(inventoryItem6);
			inventoryRepository.save(inventoryItem7);
		};
	}
}
