package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Product;
import com.pizzashop.pizzashop.Repositories.ProductsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    @GetMapping
    public Iterable<Product> getAllProducts(){
        return this.productsRepository.findAll();
    }

    @PostMapping
    ResponseEntity<Product> newProduct(@RequestBody Product newProduct) {
        return new ResponseEntity<>(this.productsRepository.save(newProduct), HttpStatus.OK);
    }

}
