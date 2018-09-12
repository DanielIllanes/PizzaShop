package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Ingredients;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private IngredientsRepository ingredientsRepository;

    public IngredientsController(IngredientsRepository ingredientsRepository){
        this.ingredientsRepository = ingredientsRepository;
    }

    @GetMapping
    public Iterable<Ingredients> allIngredients(){
        return this.ingredientsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingredients> byId(@PathVariable(value= "id") Long id){
        return this.ingredientsRepository.findById(id);
    }

    @GetMapping("/new/{name}")
    public String addIngredient(@PathVariable(value = "name") String name) {
        Ingredients ingredient = new Ingredients(name);
        if(this.ingredientsRepository.save(ingredient) != null){
            return "Ingredients added successfully";
        }
        return "Something went wrong adding the new Ingredients";
    }
}
