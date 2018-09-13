package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Ingredient;
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
    public Iterable<Ingredient> allIngredients(){
        return this.ingredientsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> byId(@PathVariable(value= "id") Long id){
        return this.ingredientsRepository.findById(id);
    }

    @GetMapping("/new/{name}")
    public String addIngredient(@PathVariable(value = "name") String name) {
        Ingredient ingredient = new Ingredient(name);
        try{
            if(this.ingredientsRepository.save(ingredient) != null){
                return "Ingredient added successfully";
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return "Something went wrong adding the new Ingredient";

    }
}
