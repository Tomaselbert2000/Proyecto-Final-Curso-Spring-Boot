package com.example.proyecto_final_curso_springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MayorVentaDTO {
    /*
    Usamos un Data Transfer Object para reunir los siguientes datos acerca de la venta con el monto más alto de todas las registradas:
    - codigo de venta
    - total
    - cantidad de productos
    - nombre del cliente
    - apellido del cliente
     */

    private long codigo_venta;
    private double total_venta;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public MayorVentaDTO() {
    }

    public MayorVentaDTO(long codigo_venta, double total_venta, int cantidad_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total_venta = total_venta;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
}
