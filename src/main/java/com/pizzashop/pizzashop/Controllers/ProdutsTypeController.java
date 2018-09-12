package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.ProductType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productTypes")
public class ProdutsTypeController {
    @GetMapping()
    public ProductType[] allProductsTypes() {return ProductType.values();}
}
