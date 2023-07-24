package com.platzi.marcket.domain.service;

import com.platzi.marcket.domain.Producto;
import com.platzi.marcket.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAll(){
        return productoRepository.getAll();
    }

    public Optional<List<Producto>> getByCategoria(int categoriaId){
        return productoRepository.getByCategoria(categoriaId);
    }

    public Optional<Producto> getProducto(int productoId){
        return productoRepository.getProducto(productoId);
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.crearProducto(producto);
    }

    public boolean eliminarProducto(int productoId){
        return getProducto(productoId).map(producto -> {
            productoRepository.eliminarProducto(productoId);
            return true;
        }).orElse(false);
    }

}
