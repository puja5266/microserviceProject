package com.programingtechie.inventoryservice.service;

import com.programingtechie.inventoryservice.dto.InventoryResponse;
import com.programingtechie.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInSock(List<String> skuCode) {
    return inventoryRepository.findBySkuCodeIn(skuCode).stream()
            .map(inventory ->
                InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build()
            ).toList();

    }
}
