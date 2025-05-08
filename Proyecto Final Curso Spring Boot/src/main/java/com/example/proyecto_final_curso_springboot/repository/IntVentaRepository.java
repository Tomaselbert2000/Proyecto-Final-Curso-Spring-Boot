package com.example.proyecto_final_curso_springboot.repository;

import com.example.proyecto_final_curso_springboot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntVentaRepository extends JpaRepository<Venta, Long> {
}
