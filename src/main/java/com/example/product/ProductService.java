package com.example.product.service;

import com.example.product.Command;
import com.example.product.IProductRepository;
import com.example.product.model.Product;
import com.example.product.model.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<ProductDto, String> {
    private final IProductRepository iProductRepository;

    public CreateProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public String execute(ProductDto input) {
        Product product = input.toProduct();
        int id = iProductRepository.save(product).getId();
        return String.format("Product %d, created", id);
    }
}