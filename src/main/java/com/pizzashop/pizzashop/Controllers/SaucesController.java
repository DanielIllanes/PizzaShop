package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Sauce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sauces")
public class SaucesController {
    @GetMapping
    public Sauce[] allSauces(){
        return Sauce.values();
    }
}
