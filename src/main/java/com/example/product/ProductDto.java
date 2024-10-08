package com.example.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private final int id;
    private final String name;
    private final String description;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }

    public Product toProduct() {
        var product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        return product;
    }
}