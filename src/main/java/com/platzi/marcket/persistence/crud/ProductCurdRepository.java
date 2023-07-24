package com.platzi.marcket.persistence.crud;

import com.platzi.marcket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductCurdRepository  extends CrudRepository<Product, Integer> {
    List<Product> findByCategoryIdOrderByNameAsc(Integer categoryId);
    Optional<List<Product>> findByStockLessThanAndState(int stock, boolean state);
}
