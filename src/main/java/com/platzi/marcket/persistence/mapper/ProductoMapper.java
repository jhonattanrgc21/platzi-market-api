package com.platzi.marcket.persistence.mapper;

import com.platzi.marcket.domain.Producto;
import com.platzi.marcket.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface ProductoMapper {

    @Mappings({
            @Mapping(source = "id", target = "productoId"),
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "categoryId", target = "categoriaId"),
            @Mapping(source = "category", target = "categoria"),
            @Mapping(source = "price", target = "precio"),
            @Mapping(source = "stock", target = "cantidad"),
            @Mapping(source = "state", target = "activo")
    })
    Producto toProducto(Product product);
    List<Producto> toProductos(List<Product> productList);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(Producto producto);
}
