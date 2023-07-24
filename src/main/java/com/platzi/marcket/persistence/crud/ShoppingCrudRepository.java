package com.platzi.marcket.persistence.crud;

import com.platzi.marcket.persistence.entity.Shopping;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCrudRepository extends CrudRepository<Shopping, Integer> {
    Optional<List<Shopping>> findByClientId(String clientId);
}
