package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.PizzaType;
import com.pizzashop.pizzashop.Repositories.PizzasTypesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizzas-types")
public class PizzasTypesController {
    private PizzasTypesRepository pizzasTypesRepository;

    public PizzasTypesController(PizzasTypesRepository pizzasTypesRepository){
        this.pizzasTypesRepository = pizzasTypesRepository;
    }

    @GetMapping
    public Page<PizzaType> allPizzaTypes(Pageable pageable){
        return this.pizzasTypesRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaType> getPizzaTypeById(@PathVariable(value = "id") Long id){
        if(!this.pizzasTypesRepository.findById(id).isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(this.pizzasTypesRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PizzaType> newPizzaType(@RequestBody PizzaType newPizzaType) {
        return new ResponseEntity<>(this.pizzasTypesRepository.save(newPizzaType), HttpStatus.CREATED);
    }
}
