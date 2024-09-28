package com.example.product.controller;

import com.example.product.model.ProductDto;
import com.example.product.service.AllProductService;
import com.example.product.service.CreateProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {
    AllProductService allProductService;
    CreateProductService createProductService;

    ProductController(AllProductService allProductService, CreateProductService createProductService) {
        this.allProductService = allProductService;
        this.createProductService = createProductService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createProductService.execute(productDto));
    }

    @GetMapping
    public ResponseEntity<String> obtain() {
        return ResponseEntity.status(HttpStatus.OK).body("The product");
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.updateProductService.execute(new UpdateProductDto(id, productDto))
        );
    }

    @GetMapping("all")
    public ResponseEntity<List<ProductDto>> index() {
        return ResponseEntity.status(HttpStatus.OK).body(this.allProductService.execute(null));
    }
}