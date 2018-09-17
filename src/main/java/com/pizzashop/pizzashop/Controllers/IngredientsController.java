package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Ingredient;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import com.sun.deploy.net.HttpResponse;
import jdk.net.SocketFlow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private IngredientsRepository ingredientsRepository;

    public IngredientsController(IngredientsRepository ingredientsRepository){
        this.ingredientsRepository = ingredientsRepository;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients(){
        return this.ingredientsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> byId(@PathVariable(value= "id") Long id){
        return this.ingredientsRepository.findById(id);
    }

    @PostMapping
    ResponseEntity<Ingredient> newIngredient(@RequestBody Ingredient newIngredient) {
        return new ResponseEntity<>(this.ingredientsRepository.save(newIngredient), HttpStatus.OK);
    }
}
