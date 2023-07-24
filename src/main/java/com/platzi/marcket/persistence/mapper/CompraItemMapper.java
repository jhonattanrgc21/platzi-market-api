package com.platzi.marcket.persistence.mapper;

import com.platzi.marcket.domain.CompraItem;
import com.platzi.marcket.persistence.entity.ProductShopping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CompraItemMapper {
    @Mappings({
            @Mapping(source = "id.productId", target = "productoId"),
            @Mapping(source = "quantity", target = "cantidad"),
            @Mapping(source = "state", target = "activo")
    })
    CompraItem toCompraItem(ProductShopping productShopping);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "shopping", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.shoppingId", ignore = true)
    })
    ProductShopping toProductShopping(CompraItem compraItem);
}
