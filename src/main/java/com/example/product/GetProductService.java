package com.example.product.service;

import com.example.product.IProductRepository;
import com.example.product.Query;
import com.example.product.model.Product;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class GetProductService implements Query<Integer, Product> {
    private final IProductRepository iProductRepository;

    public GetProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public Product execute(Integer id) {
        Optional<Product> product = this.iProductRepository.findById(id);
        return product.orElse(null);
    }
}