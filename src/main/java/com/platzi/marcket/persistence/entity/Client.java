package com.platzi.marcket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String firstName;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "celular")
    private String phone;
    @Column(name = "direccion")
    private String address;
    @Column(name = "correo")
    private String email;
}
