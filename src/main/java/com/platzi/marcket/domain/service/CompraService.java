package com.platzi.marcket.domain.service;

import com.platzi.marcket.domain.Compra;
import com.platzi.marcket.domain.Producto;
import com.platzi.marcket.domain.repository.CompraRepository;
import com.platzi.marcket.persistence.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> getAll(){
        return compraRepository.getAll();
    }
    public Compra crearCompra(Compra compra){
        return  compraRepository.crearCompra(compra);
    }

    public Optional<List<Compra>> getByCliente(String clienteId){
        return compraRepository.getByCliente(clienteId);
    }
}
