package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Ingredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredients,Long> {
}
