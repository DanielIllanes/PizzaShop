package com.pizzashop.pizzashop.Repositories;


import com.pizzashop.pizzashop.Models.Topping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingsRepository extends CrudRepository<Topping, Long> {
}
