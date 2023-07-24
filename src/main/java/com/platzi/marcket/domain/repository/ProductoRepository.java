package com.platzi.marcket.domain.repository;

import com.platzi.marcket.domain.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    List<Producto> getAll();
    Optional<List<Producto>> getByCategoria(int categoriaId);
    Optional< List<Producto>> getProductosEscasos(int cantidad);
    Optional<Producto> getProducto(int productoId);
    Producto crearProducto(Producto producto);
    void  eliminarProducto(int productoId);
}
