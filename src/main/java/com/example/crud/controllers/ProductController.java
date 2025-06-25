package com.example.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.CrudApplication;
import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProduct;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final CrudApplication crudApplication;
	@Autowired
	
	private ProductRepository repository;

    ProductController(CrudApplication crudApplication) {
        this.crudApplication = crudApplication;
    }
	
	@GetMapping
	public ResponseEntity getAllProducts() {
		var allProducts = repository.findAll();
		return ResponseEntity.ok(allProducts);
	}
	
	@PostMapping
	public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data) {
		System.out.println(data);
		return ResponseEntity.ok().build();
	}
}
