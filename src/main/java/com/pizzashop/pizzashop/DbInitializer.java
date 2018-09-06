package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.Topping;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {
    private ToppingsRepository bankAccountRepository;

    public DbInitializer(ToppingsRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.bankAccountRepository.deleteAll();

        Topping topping1 = new Topping("Brocoli");
        Topping topping2 = new Topping("Pineapple");

        this.bankAccountRepository.save(topping1);
        this.bankAccountRepository.save(topping2);

        System.out.println(" -- Database has been initialized");
    }
}

