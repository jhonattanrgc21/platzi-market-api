package com.platzi.marcket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;
    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category cateforyId;
    @Column(name = "codigo_barras")
    private String barcode;
    @Column(name = "precio_venta")
    private Double price;
    @Column(name = "cantidad_stock")
    private Integer stock;
    @Column(name = "estado")
    private Boolean state;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCateforyId() {
        return cateforyId;
    }

    public void setCateforyId(Category cateforyId) {
        this.cateforyId = cateforyId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
