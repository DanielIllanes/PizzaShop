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
        /*
        this.toppingsRepository.deleteAll();

        Toppings topping1 = new Toppings("Corn");
        Toppings topping2 = new Toppings("Bacon");
        Toppings topping3 = new Toppings("Onions");
        Toppings topping4 = new Toppings("Green Olives");
        Toppings topping5 = new Toppings("Mushrooms");
        Toppings topping6 = new Toppings("Pineapple");

        Ingredients ingredient1 = new Ingredients("Flour");
        Ingredients ingredient2 = new Ingredients("Pepperoni");
        Ingredients ingredient3 = new Ingredients("Crushed red pepper");
        Ingredients ingredient4 = new Ingredients("yeast");

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

        PizzaTypes pizzaType1 = new PizzaTypes("Hawaiian");
        PizzaTypes pizzaType2 = new PizzaTypes("Spagnole");
        PizzaTypes pizzaType3 = new PizzaTypes("Brazilian");
        PizzaTypes pizzaType4 = new PizzaTypes("Veggie");

        this.pizzasTypesRepository.save(pizzaType1);
        this.pizzasTypesRepository.save(pizzaType2);
        this.pizzasTypesRepository.save(pizzaType3);
        this.pizzasTypesRepository.save(pizzaType4);

        Pizzas pizza1 = new Pizzas(pizzaType1, Sauce.TOMATO, Cheese.CHEDDAR, Crust.THIN, toppings , ingredients);
        Pizzas pizza2 = new Pizzas(pizzaType2, Sauce.TOMATO, Cheese.ROQUEFORT, Crust.THIN, toppings, ingredients);
        Pizzas pizza3 = new Pizzas(pizzaType3, Sauce.TOMATO, Cheese.MANCHEGO, Crust.THIN, toppings, ingredients);
        Pizzas pizza4 = new Pizzas(pizzaType4, Sauce.TOMATO, Cheese.ROQUEFORT, Crust.FILLED_WITH_CHEESE, toppings, ingredients);

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

*/
        System.out.println(" -- Database has been initialized");
    }
}

