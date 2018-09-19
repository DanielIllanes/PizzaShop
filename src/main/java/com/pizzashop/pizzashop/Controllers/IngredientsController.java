package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Ingredient;
import com.pizzashop.pizzashop.Repositories.IngredientsRepository;
import com.sun.deploy.net.HttpResponse;
import jdk.net.SocketFlow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/ingredients")
public class IngredientsController {
    private IngredientsRepository ingredientsRepository;

    public IngredientsController(IngredientsRepository ingredientsRepository){
        this.ingredientsRepository = ingredientsRepository;
    }

    @GetMapping
    public Page<Ingredient> allIngredients(Pageable pageable){
        return this.ingredientsRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    ResponseEntity<Ingredient> byId(@PathVariable(value= "id") Long id){
        if(!this.ingredientsRepository.findById(id).isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(this.ingredientsRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Ingredient> newIngredient(@RequestBody Ingredient newIngredient) {
        return new ResponseEntity<>(this.ingredientsRepository.save(newIngredient), HttpStatus.CREATED);
    }
}
