package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Cheese;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheeses")
public class CheesesController {
    @GetMapping
    public Cheese[] allCheeses(){
        return Cheese.values();
    }
}
