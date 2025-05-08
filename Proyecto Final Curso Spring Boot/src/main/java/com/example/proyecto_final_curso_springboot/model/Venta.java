package com.example.proyecto_final_curso_springboot.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("ALL")
@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    @OneToMany
    List<Producto> listaProductos;
    @OneToOne
    Cliente cliente;

    public Venta() {
    }

    public Venta(long codigo_venta, LocalDate fecha_venta, double total, List<Producto> listaProductos, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.cliente = cliente;
    }
}
