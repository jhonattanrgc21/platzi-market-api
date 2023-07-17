package com.platzi.marcket.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ProductShoppingPk  implements Serializable {
    @Column(name = "id_compra")
    private Integer shippingId;

    @Column(name = "id_producto")
    private Integer productId;

    public ProductShoppingPk() {
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
