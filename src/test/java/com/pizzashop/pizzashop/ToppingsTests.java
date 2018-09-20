package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.Topping;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
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
public class ToppingsTests {

    @Autowired
    private ToppingsRepository toppingsRepository;

    @Test
    public void findToppingByNameTest(){
        String toppingName;
        String resultName;

        Given:
        toppingName = "Onions";

        When:
        resultName = this.toppingsRepository.findByName(toppingName).getName();

        Then:
        assertEquals(toppingName, resultName);
    }

    @Test
    public void addNewToppingTest(){
        Topping newTopping;
        Topping savedTopping;

        Given:
        newTopping = new Topping("Barbecue");

        When:
        this.toppingsRepository.save(newTopping);
        savedTopping = this.toppingsRepository.findByName(newTopping.getName());

        Then:
        assertEquals(newTopping.getName(),savedTopping.getName());
    }

    @Test
    public void getAllToppingsTest(){
        List<Topping> toppingsList;

        When:
        toppingsList = (List<Topping>) this.toppingsRepository.findAll();

        Then:
        assertThat(toppingsList, hasSize(7));
    }
}
