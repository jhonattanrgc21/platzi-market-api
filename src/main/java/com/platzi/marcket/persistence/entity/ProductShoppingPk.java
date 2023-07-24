package com.platzi.marcket.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ProductShoppingPk  implements Serializable {
    @Column(name = "id_compra")
    private Integer shoppingId;

    @Column(name = "id_producto")
    private Integer productId;

    public ProductShoppingPk() {
    }

    public Integer getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
