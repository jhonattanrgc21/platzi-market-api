package com.platzi.marcket.persistence.mapper;

import com.platzi.marcket.domain.Categoria;
import com.platzi.marcket.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    @Mappings({
            @Mapping(source = "id", target = "categoriaId"),
            @Mapping(source = "description", target = "descripcion"),
            @Mapping(source = "state", target = "activo")
    })
    Categoria toCategoria(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productList", ignore = true)
    Category toCategory(Categoria categoria);
}
