package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends PagingAndSortingRepository<Order, Long> {
    Order findByName(@Param("name") String name);
}
