package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Cheese;
import com.pizzashop.pizzashop.Repositories.CheesesRepository;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/cheeses")
public class CheesesController {
    private CheesesRepository cheesesRepository;

    public CheesesController(CheesesRepository cheesesRepository){
        this.cheesesRepository = cheesesRepository;
    }

    @GetMapping
    public Iterable<Cheese> allToppings(){
        return this.cheesesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cheese> byId(@PathVariable(value= "id") Long id){
        return this.cheesesRepository.findById(id);
    }

    @GetMapping("/provider/{provider}")
    public Optional<Cheese> byLocation(@PathVariable(value = "provider") String provider) { return this.cheesesRepository.findByProvider(provider);}

    @GetMapping("/new/{name}/{provider}")
    public String addCheese(@PathVariable(value = "name") String name, @PathVariable(value = "provider") String provider) {
        Cheese c = new Cheese(name,provider);
        if(this.cheesesRepository.save(c) != null){
            return "Cheese added successfully";
        }
        return "Something went wrong adding the cheese";
    }
}
