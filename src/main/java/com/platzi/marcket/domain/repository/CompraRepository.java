package com.platzi.marcket.domain.repository;

import com.platzi.marcket.domain.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraRepository {
    List<Compra> getAll();
    Optional<List<Compra>> getByCliente(String clienteId);
    Compra crearCompra(Compra compra);
}
