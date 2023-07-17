package com.platzi.marcket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_producto")
public class ProductShopping {
    @EmbeddedId
    private ProductShoppingPk id;
    @Column(name = "cantidad")
    private Integer count;

    @Column(name = "total")
     private Double total;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}
