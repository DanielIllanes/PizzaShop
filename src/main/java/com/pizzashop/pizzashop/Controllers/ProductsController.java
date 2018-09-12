package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Product;
import com.pizzashop.pizzashop.Repositories.ProductsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
