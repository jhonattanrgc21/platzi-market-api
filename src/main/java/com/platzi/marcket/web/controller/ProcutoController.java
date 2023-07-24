package com.platzi.marcket.web.controller;

import com.platzi.marcket.domain.Producto;
import com.platzi.marcket.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProcutoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("all")
    public ResponseEntity<List<Producto>> getAll(){
        return new ResponseEntity<>(productoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("allByCategory/{categoryId}")
    public ResponseEntity<List<Producto>> getByCategoria(@PathVariable("categoryId") int categoriaId){
        List<Producto> productoList = productoService.getByCategoria(categoriaId).orElse(null);

        return productoList != null && !productoList.isEmpty() ?
                new ResponseEntity<>(productoList, HttpStatus.OK)
                : new ResponseEntity<List<Producto>>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<Producto> getProducto(@PathVariable("productId") int productoId){
        Producto producto = productoService.getProducto(productoId).orElse(null);
        return producto != null? new ResponseEntity<>(producto, HttpStatus.OK)
                :new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity eliminarProducto(@PathVariable("productId") int productoId){
        return productoService.eliminarProducto(productoId)? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
