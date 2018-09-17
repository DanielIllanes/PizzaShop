package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.PizzaType;
import com.pizzashop.pizzashop.Repositories.PizzasTypesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pizzas-types")
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
    public Optional<PizzaType> getPizzaTypeById(@PathVariable(value = "id") java.lang.Long id){
        return this.pizzasTypesRepository.findById(id);
    }

    @PostMapping
    ResponseEntity<PizzaType> newPizzaType(@RequestBody PizzaType newPizzaType) {
        return new ResponseEntity<>(this.pizzasTypesRepository.save(newPizzaType), HttpStatus.OK);
    }
}
