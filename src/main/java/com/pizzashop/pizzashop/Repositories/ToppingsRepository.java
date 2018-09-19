package com.pizzashop.pizzashop.Repositories;


import com.pizzashop.pizzashop.Models.Topping;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingsRepository extends PagingAndSortingRepository<Topping, Long> {
    Topping findByName(@Param("name") String name);
}
