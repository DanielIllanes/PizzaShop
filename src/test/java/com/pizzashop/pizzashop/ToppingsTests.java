package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.Topping;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToppingsTests {

    @Autowired
    private ToppingsRepository toppingsRepository;

    @Test
    public void findToppingByNameTest(){
        String toppingName = "Onions";
        assertEquals(toppingName, this.toppingsRepository.findByName(toppingName).getName());
    }

    @Test
    public void addNewToppingTest(){
        Topping newTopping = new Topping("Spinaca");
        this.toppingsRepository.save(newTopping);
        Topping savedTopping = this.toppingsRepository.findByName(newTopping.getName());
        assertEquals(newTopping.getName(), savedTopping.getName());
    }

    @Test
    public void getAllToppingsTest(){
        //THERE ARE 5 INGREDIENTS ALREADY IN DATABASE
        Iterable<Topping> toppingsList = this.toppingsRepository.findAll();
        int numberOfTOppings = 0;
        for (Topping topping: toppingsList ) {
            numberOfTOppings++;
        }
        assertEquals(7, numberOfTOppings);
    }
}
