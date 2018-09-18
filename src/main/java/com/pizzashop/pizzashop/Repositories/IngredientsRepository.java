package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends PagingAndSortingRepository<Ingredient,Long> {
}
