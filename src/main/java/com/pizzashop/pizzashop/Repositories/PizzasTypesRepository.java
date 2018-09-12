package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.PizzaTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzasTypesRepository extends CrudRepository<PizzaTypes,Long> {
}
