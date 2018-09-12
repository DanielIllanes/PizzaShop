package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Pizzas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzasRepository extends CrudRepository<Pizzas,Long> {
}
