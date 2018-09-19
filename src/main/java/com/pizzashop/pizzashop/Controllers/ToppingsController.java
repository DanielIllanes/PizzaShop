package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Topping;
import com.pizzashop.pizzashop.Repositories.ToppingsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/toppings")
public class ToppingsController {
    private ToppingsRepository toppingsRepository;

    public ToppingsController(ToppingsRepository toppingsRepository){
        this.toppingsRepository = toppingsRepository;
    }

    @GetMapping
    public Page<Topping> allToppings(Pageable pageable){
        return this.toppingsRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    ResponseEntity<Topping> byId(@PathVariable(value= "id") Long id){
        if(!this.toppingsRepository.findById(id).isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(this.toppingsRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Topping> newTopping(@RequestBody Topping newTopping) {
        return new ResponseEntity<>(this.toppingsRepository.save(newTopping), HttpStatus.CREATED);
    }
}
