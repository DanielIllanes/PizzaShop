package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Pizza;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import com.pizzashop.pizzashop.Repositories.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzasController {
    private PizzasRepository pizzasRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public PizzasController(PizzasRepository pizzasRepository){
        this.pizzasRepository = pizzasRepository;
    }

    @GetMapping()
    public Iterable<Pizza> allPizzas(){
        Iterable<Pizza> pizzas = this.pizzasRepository.findAll();
        pizzas.forEach(item -> item.setIngredients(convertIngredients(item.getIngredients())));
        pizzas.forEach(item -> item.setToppings(convertToppings(item.getToppings())));
        return pizzas;
    }

    public List<String> convertIngredients(List<String> ingredientsIdList){
        List<String> list = new ArrayList<String>();
        for(String ingredientId : ingredientsIdList){
            list.add(this.ingredientsRepository.findById(Long.parseLong(ingredientId)).get().getName());
        }
        return list;
    }

    public List<String> convertToppings(List<String> toppingsIdList){
        List<String> list = new ArrayList<String>();
        for(String toppingId : toppingsIdList){
            list.add(this.ingredientsRepository.findById(Long.parseLong(toppingId)).get().getName());
        }
        return list;
    }
}
