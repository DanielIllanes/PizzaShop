package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.PizzaType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzasTypesRepository extends PagingAndSortingRepository<PizzaType, Long> {
    PizzaType findByName(@Param("name") String name);
}
