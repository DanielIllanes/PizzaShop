package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Pizza;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import com.pizzashop.pizzashop.Repositories.PizzasRepository;
import com.pizzashop.pizzashop.Repositories.PizzasTypesRepository;
import com.pizzashop.pizzashop.StringListConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping()
    public Iterable<Pizza> allPizzas(){
        Iterable<Pizza> pizzas =this.pizzasRepository.findAll();
        pizzas.forEach(item -> item.setPizzatype(convertPizzaType(item.getPizzatype())));
        pizzas.forEach(item -> item.setToppings(convertToppings(item.getToppings())));
        pizzas.forEach(item -> item.setIngredients(convertIngredients(item.getIngredients())));
        return pizzas;
    }

    public String convertPizzaType(String pizzaTypeId){
        long id = Integer.parseInt(pizzaTypeId);
        String.format("%s",this.pizzasTypesRepository.findById(id));
        return "0";
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
