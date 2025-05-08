package com.example.proyecto_final_curso_springboot.service;

import com.example.proyecto_final_curso_springboot.dto.MayorVentaDTO;
import com.example.proyecto_final_curso_springboot.dto.VentasFechaDTO;
import com.example.proyecto_final_curso_springboot.model.Venta;

import java.time.LocalDate;
import java.util.List;
// definimos los metodos necesarios para realizar CRUD de Ventas en la base de datos
public interface IntVentaService {

    public void crearVenta(Venta venta);
    public void eliminarVenta(long id);
    public void editarDatosVenta(Venta venta);
    public Venta consultarDatosVenta(long id);
    public List<Venta> consultarVentas();
    public VentasFechaDTO MontosVentasFecha(LocalDate fecha);
    public Venta MayorMonto ();
    public MayorVentaDTO DatosMayorVenta();
}
