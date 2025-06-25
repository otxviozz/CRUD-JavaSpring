package com.example.crud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.CrudApplication;
import com.example.crud.domain.product.DeleteProductRequest;
import com.example.crud.domain.product.Product;
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
		Product newProduct = new Product(data);
		repository.save(newProduct);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@DeleteMapping
	@Transactional
	public ResponseEntity deleteProduct(@RequestBody @Valid DeleteProductRequest data) {
	    Optional<Product> optionalProduct = repository.findById(data.id());
	    if (optionalProduct.isPresent()) {
	        repository.delete(optionalProduct.get());
	        return ResponseEntity.noContent().build(); // 204 - No Content
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
