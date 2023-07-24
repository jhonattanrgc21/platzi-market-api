package com.platzi.marcket.persistence;

import com.platzi.marcket.domain.Producto;
import com.platzi.marcket.domain.repository.ProductoRepository;
import com.platzi.marcket.persistence.crud.ProductCurdRepository;
import com.platzi.marcket.persistence.entity.Product;
import com.platzi.marcket.persistence.mapper.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository  implements ProductoRepository {
    @Autowired
    private ProductCurdRepository productCurdRepository;
   @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<Producto> getAll(){
        List<Product> productList = (List<Product>) productCurdRepository.findAll();
        return  productoMapper.toProductos(productList);
    }

    @Override
    public Optional<List<Producto>> getByCategoria(int categoriaId) {
        List<Product> productList = productCurdRepository.findByCategoryIdOrderByNameAsc(categoriaId);
        return Optional.of(productoMapper.toProductos(productList)) ;
    }

    @Override
    public Optional<List<Producto>> getProductosEscasos(int cantidad) {
        Optional<List<Product>> productList = productCurdRepository.findByStockLessThanAndState(cantidad, true);
        return productList.map(products -> productoMapper.toProductos(products));
    }

    @Override
    public Optional<Producto> getProducto(int productoId) {
        Optional<Product> product = productCurdRepository.findById(productoId);
        return product.map(prod -> productoMapper.toProducto(prod));
    }

    @Override
    public Producto crearProducto(Producto producto) {
        Product newProduct =  productoMapper.toProduct(producto);
        Product entity = productCurdRepository.save(newProduct);
        return productoMapper.toProducto(entity);
    }

    @Override
    public void eliminarProducto(int productoId) {
        productCurdRepository.deleteById(productoId);
    }
}
