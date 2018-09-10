package com.pizzashop.pizzashop.Repositories;

import com.pizzashop.pizzashop.Models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheesesRepository extends CrudRepository<Cheese,Long> {
    Optional<Cheese> findByProvider(@Param("provider") String location);
}
