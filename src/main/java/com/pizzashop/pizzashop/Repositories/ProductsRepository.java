package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product,Long> {
}
