package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.PizzaType;
import com.pizzashop.pizzashop.Repositories.PizzasTypesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/pizzaTypes")
public class PizzasTypesController {
    private PizzasTypesRepository pizzasTypesRepository;

    public PizzasTypesController(PizzasTypesRepository pizzasTypesRepository){
        this.pizzasTypesRepository = pizzasTypesRepository;
    }

    @GetMapping
    public Iterable<PizzaType> allPizzaTypes(){
        return this.pizzasTypesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PizzaType> getPizzaTypeById(@PathVariable(value = "id") Long id){
        return this.pizzasTypesRepository.findById(id);
    }

    @GetMapping("/new/{name}")
    public String addPizzaType(@PathVariable(value = "name") String name) {
        PizzaType ingredient = new PizzaType(name);
        if(this.pizzasTypesRepository.save(ingredient) != null){
            return "Pizza type added successfully";
        }
        return "Something went wrong adding the new type of pizza";
    }
}
