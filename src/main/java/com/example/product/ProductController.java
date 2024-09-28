package com.example.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @PostMapping
    public ResponseEntity<String> create() {
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> obtain() {
        return new ResponseEntity<>("The product", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }
}
