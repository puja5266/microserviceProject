package com.programingtechie.inventoryservice.controller;

import com.programingtechie.inventoryservice.dto.InventoryResponse;
import com.programingtechie.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory?sku-code=iphone-13&sku-code=iphone13-red
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    private List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
    return inventoryService.isInSock(skuCode);

    }
}
