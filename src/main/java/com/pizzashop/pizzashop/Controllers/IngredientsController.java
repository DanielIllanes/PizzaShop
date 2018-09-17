package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Ingredient;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    Ingredient newIngredient(@RequestBody Ingredient newIngredient) {
        return this.ingredientsRepository.save(newIngredient);
    }
}
