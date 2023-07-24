package com.platzi.marcket.persistence;

import com.platzi.marcket.domain.Compra;
import com.platzi.marcket.domain.repository.CompraRepository;
import com.platzi.marcket.persistence.crud.ShoppingCrudRepository;
import com.platzi.marcket.persistence.entity.Shopping;
import com.platzi.marcket.persistence.mapper.CompraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingRepository implements CompraRepository {
    @Autowired
    private ShoppingCrudRepository shoppingCrudRepository;
    @Autowired
    private CompraMapper compraMapper;

    @Override
    public List<Compra> getAll() {
        return compraMapper.toCompras((List<Shopping>) shoppingCrudRepository.findAll());
    }

    @Override
    public Optional<List<Compra>> getByCliente(String clienteId) {
        return shoppingCrudRepository.findByClientId(clienteId).map(shoppings -> compraMapper.toCompras(shoppings));
    }

    @Override
    public Compra crearCompra(Compra compra) {
        Shopping shopping = compraMapper.toShopping(compra);
        shopping.getProductShopping().forEach(productShopping -> {
            productShopping.setShopping(shopping);
        });
        return compraMapper.toCompra(shopping);
    }
}
