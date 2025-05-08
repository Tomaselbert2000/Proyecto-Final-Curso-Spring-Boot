package com.example.proyecto_final_curso_springboot.repository;

import com.example.proyecto_final_curso_springboot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntProductoRepository extends JpaRepository<Producto, Long> {
}
