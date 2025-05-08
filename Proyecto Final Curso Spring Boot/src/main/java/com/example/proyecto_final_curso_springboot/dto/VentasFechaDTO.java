package com.example.proyecto_final_curso_springboot.dto;

import lombok.Getter;
import lombok.Setter;

/*
Usamos un Data Transfer Object para reunir los siguientes datos por fecha:
- sumatoria de monto
- cantidad total de ventas
 */
@Getter @Setter
public class VentasFechaDTO {
    // definimos los atributos de la clase, los cuales van a tomar valores provenientes de Venta

    private double totalVentas;
    private int cantidadVentas;

    public VentasFechaDTO() {
    }

    public VentasFechaDTO(double totalVentas, int cantidadVentas) {
        this.totalVentas = totalVentas;
        this.cantidadVentas = cantidadVentas;
    }
}
