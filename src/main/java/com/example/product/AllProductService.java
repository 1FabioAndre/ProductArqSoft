package com.example.product.service;

import com.example.product.IProductRepository;
import com.example.product.Query;
import com.example.product.model.Product;
import com.example.product.model.ProductDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AllProductService implements Query<Void, List<ProductDto>> {
    private final IProductRepository iProductRepository;

    AllProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public List<ProductDto> execute(Void input) {
        List<Product> products = iProductRepository.findAll();
        return products.stream().map(ProductDto::new).toList();
    }
}