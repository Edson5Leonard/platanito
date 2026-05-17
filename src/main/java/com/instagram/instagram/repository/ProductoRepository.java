package com.instagram.instagram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.instagram.models.Producto;






@Repository

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoriaIgnoreCase(String categoria);

    // Para cuando el usuario filtra por "SODAS" dentro de comida
    List<Producto> findBySubcategoria(String subcategoria);

    List<Producto> findByGenero(String genero);

    List<Producto> findByMarca(String marca);

    

    
}   
