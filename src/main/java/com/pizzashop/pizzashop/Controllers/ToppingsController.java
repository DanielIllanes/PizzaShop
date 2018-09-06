package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Topping;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toppings")
public class ToppingsController {
    private ToppingsRepository toppingsRepository;

    public ToppingsController(ToppingsRepository toppingsRepository){
        this.toppingsRepository = toppingsRepository;
    }

    @GetMapping("/all")
    public Iterable<Topping> all(){
        return this.toppingsRepository.findAll();
    }
}
