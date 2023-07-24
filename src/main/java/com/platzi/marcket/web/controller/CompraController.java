package com.platzi.marcket.web.controller;

import com.platzi.marcket.domain.Compra;
import com.platzi.marcket.domain.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppings")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("/all")
    public ResponseEntity<List<Compra>> getAll(){
        return new ResponseEntity<>(compraService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Compra> createCompra(@RequestBody Compra compra){
        return new ResponseEntity<>(compraService.crearCompra(compra), HttpStatus.CREATED);
    }

    @GetMapping("/allByClient/{clientId}")
    public ResponseEntity<List<Compra>> getByCategoria(@PathVariable("clientId") String clienteId){
        List<Compra> compraList = compraService.getByCliente(clienteId).orElse(null);

        return compraList != null && !compraList.isEmpty() ?
                new ResponseEntity<>(compraList, HttpStatus.OK)
                : new ResponseEntity<List<Compra>>(HttpStatus.NOT_FOUND);
    }
}
