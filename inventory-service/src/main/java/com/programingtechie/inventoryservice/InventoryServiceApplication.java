package com.programingtechie.inventoryservice;

import com.programingtechie.inventoryservice.model.Inventory;
import com.programingtechie.inventoryservice.repository.InventoryRepository;
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
	public CommandLineRunner loadDate(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("iphone_13");
			inventory2.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory1);
		};
	}
}
