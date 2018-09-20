package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.PizzaType;
import com.pizzashop.pizzashop.Repositories.PizzasTypesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaTypesTests {

    @Autowired
    private PizzasTypesRepository pizzasTypesRepository;

    @Test
    public void getAllPizzasTypesTest(){
        List<PizzaType> pizzaTypeList;

        When:
        pizzaTypeList = (List<PizzaType>) this.pizzasTypesRepository.findAll();

        Then:
        assertThat(pizzaTypeList, hasSize(4));
    }

    @Test
    public void findPizzaTypeByNameTest(){
        String pizzaTypeName;
        String resultName;

        Given:
        pizzaTypeName = "Hawaiian";

        When:
        resultName = this.pizzasTypesRepository.findByName(pizzaTypeName).getName();

        Then:
        assertEquals(pizzaTypeName, resultName);
    }

    @Test
    public void addNewPizzaTypeTest(){
        PizzaType newPizzaType;
        PizzaType savedPizzaType;

        Given:
        newPizzaType = new PizzaType("Barbecue");

        When:
        this.pizzasTypesRepository.save(newPizzaType);
        savedPizzaType = this.pizzasTypesRepository.findByName(newPizzaType.getName());

        Then:
        assertEquals(newPizzaType.getName(),savedPizzaType.getName());
    }
}
