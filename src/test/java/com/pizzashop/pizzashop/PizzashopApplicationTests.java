package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.Ingredient;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzashopApplicationTests {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Test
    public void addNewIngredientTest(){
        Ingredient newIngredient = new Ingredient("Tomato");
        this.ingredientsRepository.save(newIngredient);
        Ingredient savedIngredient = this.ingredientsRepository.findByName(newIngredient.getName());
        assertEquals(newIngredient.getName(), savedIngredient.getName());
    }

    @Test
    public void findIngredientByName(){

    }

    @Test
    public void listAllIngredientTest(){
        //THERE ARE 5 INGREDIENTS ALREADY IN DATABASE
        Iterable<Ingredient> ingredientsList = this.ingredientsRepository.findAll();
        int numberOfIngredients = 0;
        for (Ingredient i: ingredientsList ) {
            numberOfIngredients++;
        }
        assertEquals(5, numberOfIngredients);
    }




}
