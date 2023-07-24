package com.platzi.marcket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ProductShopping {
    @EmbeddedId
    private ProductShoppingPk id;
    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "total")
     private Double total;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Shopping shopping;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    public ProductShopping() {
    }

    public ProductShoppingPk getId() {
        return id;
    }

    public void setId(ProductShoppingPk id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Shopping getShopping() {
        return shopping;
    }

    public void setShopping(Shopping shopping) {
        this.shopping = shopping;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
