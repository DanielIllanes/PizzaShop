package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.PizzaType;
import com.pizzashop.pizzashop.Repositories.PizzasTypesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaTypesTests {

    @Autowired
    private PizzasTypesRepository pizzasTypesRepository;

    @Test
    public void getAllPizzasTypesTest(){
        //THERE ARE 7 INGREDIENTS ALREADY IN DATABASE
        Iterable<PizzaType> toppingsList = this.pizzasTypesRepository.findAll();
        int numberOfPizzasTypes = 0;
        for (PizzaType pizzaType: toppingsList ) {
            numberOfPizzasTypes++;
        }
        assertEquals(4, numberOfPizzasTypes);
    }

    @Test
    public void findPizzaTypeByNameTest(){
        String pizzaTypeName = "Hawaiian";
        assertEquals(pizzaTypeName, this.pizzasTypesRepository.findByName(pizzaTypeName).getName());
    }

    @Test
    public void addNewPizzaTypeTest(){
        PizzaType newPizzaType = new PizzaType("Barbecue");
        this.pizzasTypesRepository.save(newPizzaType);
        PizzaType savedTopping = this.pizzasTypesRepository.findByName(newPizzaType.getName());
        assertEquals(newPizzaType.getName(), savedTopping.getName());
    }


}
