package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.*;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import com.pizzashop.pizzashop.Repositories.PizzasRepository;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private ToppingsRepository toppingsRepository;
    private IngredientsRepository ingredientsRepository;
    private PizzasRepository pizzasRepository;

    public DatabaseLoader(ToppingsRepository toppingsRepository, IngredientsRepository ingredientsRepository, PizzasRepository pizzasRepository){
        this.toppingsRepository = toppingsRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.pizzasRepository = pizzasRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.toppingsRepository.deleteAll();

        Topping topping1 = new Topping("Corn");
        Topping topping2 = new Topping("Bacon");
        Topping topping3 = new Topping("Onions");
        Topping topping4 = new Topping("Green Olives");
        Topping topping5 = new Topping("Mushrooms");
        Topping topping6 = new Topping("Pineapple");

        Ingredient ingredient1 = new Ingredient("Flour");
        Ingredient ingredient2 = new Ingredient("Pepperoni");
        Ingredient ingredient3 = new Ingredient("Crushed red pepper");
        Ingredient ingredient4 = new Ingredient("yeast");

        this.ingredientsRepository.save(ingredient1);
        this.ingredientsRepository.save(ingredient2);
        this.ingredientsRepository.save(ingredient3);
        this.ingredientsRepository.save(ingredient4);

        this.toppingsRepository.save(topping1);
        this.toppingsRepository.save(topping2);
        this.toppingsRepository.save(topping3);
        this.toppingsRepository.save(topping4);
        this.toppingsRepository.save(topping5);
        this.toppingsRepository.save(topping6);

        List<String> toppings = new ArrayList();
        toppings.add("1");
        toppings.add("2");

        List<String> ingredients = new ArrayList();
        ingredients.add("1");
        ingredients.add("2");
        ingredients.add("4");

        Pizza pizza1 = new Pizza("Hawaiian", Sauce.TOMATO, Cheese.CHEDDAR, Crust.THIN, toppings , ingredients);
        Pizza pizza2 = new Pizza("Spagnole", Sauce.TOMATO, Cheese.ROQUEFORT, Crust.THIN, toppings, ingredients);
        Pizza pizza3 = new Pizza("Brazilian", Sauce.TOMATO, Cheese.MANCHEGO, Crust.THIN, toppings, ingredients);
        Pizza pizza4 = new Pizza("Veggie", Sauce.TOMATO, Cheese.ROQUEFORT, Crust.FILLED_WITH_CHEESE, toppings, ingredients);

        this.pizzasRepository.save(pizza1);
        this.pizzasRepository.save(pizza2);
        this.pizzasRepository.save(pizza3);
        this.pizzasRepository.save(pizza4);

        System.out.println(" -- Database has been initialized");
    }
}

