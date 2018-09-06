package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Topping;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/toppings")
public class ToppingsController {
    private ToppingsRepository toppingsRepository;

    public ToppingsController(ToppingsRepository toppingsRepository){
        this.toppingsRepository = toppingsRepository;
    }

    @GetMapping("")
    public Iterable<Topping> allToppings(){
        return this.toppingsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Topping> all(@PathVariable(value= "id") Long id){
        return this.toppingsRepository.findById(id);
    }
}
