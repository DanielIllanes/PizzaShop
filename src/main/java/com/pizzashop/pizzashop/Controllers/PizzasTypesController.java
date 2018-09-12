package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.PizzaTypes;
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
    public Iterable<PizzaTypes> allPizzaTypes(){
        return this.pizzasTypesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PizzaTypes> getPizzaTypeById(@PathVariable(value = "id") Long id){
        return this.pizzasTypesRepository.findById(id);
    }

    @GetMapping("/new/{name}")
    public String addPizzaType(@PathVariable(value = "name") String name) {
        PizzaTypes ingredient = new PizzaTypes(name);
        if(this.pizzasTypesRepository.save(ingredient) != null){
            return "Pizzas type added successfully";
        }
        return "Something went wrong adding the new type of pizza";
    }
}
