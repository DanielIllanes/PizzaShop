package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.*;
import com.pizzashop.pizzashop.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private ToppingsRepository toppingsRepository;
    private IngredientsRepository ingredientsRepository;
    private PizzasRepository pizzasRepository;
    private PizzasTypesRepository pizzasTypesRepository;
    private ProductsRepository productsRepository;

    public DatabaseLoader(ToppingsRepository toppingsRepository, IngredientsRepository ingredientsRepository,
                          PizzasRepository pizzasRepository, PizzasTypesRepository pizzasTypesRepository, ProductsRepository productsRepository){
        this.toppingsRepository = toppingsRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.pizzasRepository = pizzasRepository;
        this.pizzasTypesRepository = pizzasTypesRepository;
        this.productsRepository = productsRepository;
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

        PizzaType pizzaType1 = new PizzaType("Hawaiian");
        PizzaType pizzaType2 = new PizzaType("Spagnole");
        PizzaType pizzaType3 = new PizzaType("Brazilian");
        PizzaType pizzaType4 = new PizzaType("Veggie");

        this.pizzasTypesRepository.save(pizzaType1);
        this.pizzasTypesRepository.save(pizzaType2);
        this.pizzasTypesRepository.save(pizzaType3);
        this.pizzasTypesRepository.save(pizzaType4);

        Pizza pizza1 = new Pizza(pizzaType1, Sauce.TOMATO, Cheese.CHEDDAR, Crust.THIN, toppings , ingredients);
        Pizza pizza2 = new Pizza(pizzaType2, Sauce.TOMATO, Cheese.ROQUEFORT, Crust.THIN, toppings, ingredients);
        Pizza pizza3 = new Pizza(pizzaType3, Sauce.TOMATO, Cheese.MANCHEGO, Crust.THIN, toppings, ingredients);
        Pizza pizza4 = new Pizza(pizzaType4, Sauce.TOMATO, Cheese.ROQUEFORT, Crust.FILLED_WITH_CHEESE, toppings, ingredients);

        this.pizzasRepository.save(pizza1);
        this.pizzasRepository.save(pizza2);
        this.pizzasRepository.save(pizza3);
        this.pizzasRepository.save(pizza4);

        Product product1 = new Product(ProductType.PIZZA,pizza1.getId());
        Product product2 = new Product(ProductType.PIZZA,pizza2.getId());
        Product product3 = new Product(ProductType.PIZZA,pizza3.getId());

        this.productsRepository.save(product1);
        this.productsRepository.save(product2);
        this.productsRepository.save(product3);

        System.out.println(" -- Database has been initialized");
    }
}

