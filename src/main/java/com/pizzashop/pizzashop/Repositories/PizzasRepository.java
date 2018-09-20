package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzasRepository extends PagingAndSortingRepository<Pizza,Long> {
}
