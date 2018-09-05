package com.pizzashop.pizzashop.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddToppingsController {
    @RequestMapping("/")
    public String index() { return "Welcome to PizzaShop"; }
}
