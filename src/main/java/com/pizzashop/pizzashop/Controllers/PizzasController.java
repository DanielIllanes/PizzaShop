package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Pizza;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import com.pizzashop.pizzashop.Repositories.PizzasRepository;
import com.pizzashop.pizzashop.Repositories.PizzasTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzasController {
    private PizzasRepository pizzasRepository;

    @Autowired
    private PizzasTypesRepository pizzasTypesRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public PizzasController(PizzasRepository pizzasRepository){
        this.pizzasRepository = pizzasRepository;
    }

    @GetMapping
    public Iterable<Pizza> allPizzas(){
        Iterable<Pizza> pizzas =this.pizzasRepository.findAll();
        pizzas.forEach(item -> item.setPizzatype(convertPizzaType(item.getPizzatype())));
        pizzas.forEach(item -> item.setToppings(convertToppings(item.getToppings())));
        pizzas.forEach(item -> item.setIngredients(convertIngredients(item.getIngredients())));
        return pizzas;
    }

    @PostMapping
    ResponseEntity<Pizza> newPizza(@RequestBody Pizza newPizzaType) {
        return new ResponseEntity<>(this.pizzasRepository.save(newPizzaType), HttpStatus.CREATED);
    }

    public String convertPizzaType(String pizzaTypeId){
        long id = Integer.parseInt(pizzaTypeId);
        return String.format("%s", this.pizzasTypesRepository.findById(id).get().getName());
    }

    public String convertIngredients(String ingredientsIdList){
        List<String> myList = new ArrayList<String>(Arrays.asList(ingredientsIdList.split(",")));
        List<String> list = new ArrayList<String>();
        for(String ingredientId : myList){
            list.add(this.ingredientsRepository.findById(Long.parseLong(ingredientId)).get().getName());
        }
        return list.toString();
    }

    public String convertToppings(String toppingsIdList){
        List<String> myList = new ArrayList<String>(Arrays.asList(toppingsIdList.split(",")));
        List<String> list = new ArrayList<String>();
        for(String toppingId : myList){
            list.add(this.ingredientsRepository.findById(Long.parseLong(toppingId)).get().getName());
        }
        return list.toString();
    }
}
