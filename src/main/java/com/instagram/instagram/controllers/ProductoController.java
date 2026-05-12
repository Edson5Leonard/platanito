package com.instagram.instagram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;


import com.instagram.instagram.models.Producto;
import com.instagram.instagram.repository.ProductoRepository;


import java.util.List;

@RestController
@RequestMapping("/api/productos") 
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository; 

    
    @GetMapping("")
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) { 
        return productoRepository.findById(id)
                .map(p -> ResponseEntity.ok().body(p))
                .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/categoria/{nombreCategoria}")
    public List<Producto> listarPorCategoria(@PathVariable String nombreCategoria) {
        return productoRepository.findByCategoria(nombreCategoria);
    }

    
    @GetMapping("/subcategoria/{nombreSub}")
    public List<Producto> listarPorSubcategoria(@PathVariable String nombreSub) {
        return productoRepository.findBySubcategoria(nombreSub);
    }

    
    @GetMapping("/genero/{genero}")
    public List<Producto> listarPorGenero(@PathVariable String genero) {
        return productoRepository.findByGenero(genero);
    }
}