package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.Cheese;
import com.pizzashop.pizzashop.Models.Topping;
import com.pizzashop.pizzashop.Repositories.CheesesRepository;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private ToppingsRepository toppingsRepository;
    private CheesesRepository cheesesRepository;

    public DatabaseLoader(ToppingsRepository toppingsRepository, CheesesRepository cheesesRepository){
        this.toppingsRepository = toppingsRepository;
        this.cheesesRepository = cheesesRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.toppingsRepository.deleteAll();

        Topping topping1 = new Topping("Brocoli");
        Topping topping2 = new Topping("Bacon");
        Topping topping3 = new Topping("Onions");
        Topping topping4 = new Topping("Green Olives");
        Topping topping5 = new Topping("Mushrooms");
        Topping topping6 = new Topping("Pineapple");

        Cheese cheese1 = new Cheese("Roquefort", "Roberto");
        Cheese cheese2 = new Cheese("Manchego", "Lucia");
        Cheese cheese3 = new Cheese("Cheddar", "Maggie");
        Cheese cheese4 = new Cheese("Rio Grande", "Richard");

        this.cheesesRepository.save(cheese1);
        this.cheesesRepository.save(cheese2);
        this.cheesesRepository.save(cheese3);
        this.cheesesRepository.save(cheese4);


        this.toppingsRepository.save(topping1);
        this.toppingsRepository.save(topping2);
        this.toppingsRepository.save(topping3);
        this.toppingsRepository.save(topping4);
        this.toppingsRepository.save(topping5);
        this.toppingsRepository.save(topping6);

        System.out.println(" -- Database has been initialized");
    }
}

