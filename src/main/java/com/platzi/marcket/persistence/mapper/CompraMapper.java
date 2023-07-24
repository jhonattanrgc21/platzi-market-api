package com.platzi.marcket.persistence.mapper;

import com.platzi.marcket.domain.Compra;
import com.platzi.marcket.persistence.entity.Shopping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CompraItemMapper.class})
public interface CompraMapper {
    @Mappings({
            @Mapping(source = "id", target = "compraId"),
            @Mapping(source = "clientId", target = "clienteId"),
            @Mapping(source = "date", target = "fecha"),
            @Mapping(source = "paymentMethod", target = "metodoPago"),
            @Mapping(source = "state", target = "estado"),
            @Mapping(source = "comment", target = "comentario"),
            @Mapping(source = "productShopping", target = "compraItemList")
    })
    Compra toCompra(Shopping shopping);
    List<Compra> toCompras(List<Shopping> shoppingList);
    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Shopping toShopping(Compra compra);

}
