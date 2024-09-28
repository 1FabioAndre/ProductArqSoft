package com.example.product.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @PostMapping
    public String create() {
        return "Created";
    }

    @GetMapping
    public String obtain() {
        return "The product";
    }

    @DeleteMapping
    public String delete() {
        return "Deleted";
    }

    @PutMapping
    public String update() {
        return "Updated";
    }
}