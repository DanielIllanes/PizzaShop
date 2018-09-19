package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Ingredient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends PagingAndSortingRepository<Ingredient,Long> {
    Ingredient findByName(@Param("name") String name);
}
