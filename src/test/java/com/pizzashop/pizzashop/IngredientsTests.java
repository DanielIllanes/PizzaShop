package com.pizzashop.pizzashop;

import com.pizzashop.pizzashop.Models.Ingredient;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
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
public class IngredientsTests {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Test
    public void addNewIngredientTest(){
        Ingredient newIngredient;
        Ingredient savedIngredient;
        Given:
        newIngredient = new Ingredient("Tomato");

        When:
        this.ingredientsRepository.save(newIngredient);
        savedIngredient = this.ingredientsRepository.findByName(newIngredient.getName());

        Then:
        assertEquals(newIngredient.getName(),savedIngredient.getName());
    }

    @Test
    public void findIngredientByNameTest(){
        String ingredientName;
        String resultName;

        Given:
        ingredientName = "Yeast";

        When:
        resultName = this.ingredientsRepository.findByName(ingredientName).getName();

        Then:
        assertEquals(ingredientName, resultName);
    }

    @Test
    public void getAllIngredientsTest(){
        List<Ingredient> ingredientsList;

        When:
        ingredientsList = (List<Ingredient>) this.ingredientsRepository.findAll();

        Then:
        assertThat(ingredientsList, hasSize(5));
    }
}
