package com.example.proyecto_final_curso_springboot.controller;

import com.example.proyecto_final_curso_springboot.dto.MayorVentaDTO;
import com.example.proyecto_final_curso_springboot.dto.VentasFechaDTO;
import com.example.proyecto_final_curso_springboot.model.Producto;
import com.example.proyecto_final_curso_springboot.model.Venta;
import com.example.proyecto_final_curso_springboot.service.IntVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IntVentaService intVentaService; // inyectamos dependencias

    // a continuacion definimos las rutas y metodos para cada endpoint

    @PostMapping("/ventas/crear")
    public void crearVenta(@RequestBody Venta venta) {
        intVentaService.crearVenta(venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable long codigo_venta) {
        intVentaService.eliminarVenta(codigo_venta);
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta buscarVenta(@PathVariable long codigo_venta) {
        return intVentaService.consultarDatosVenta(codigo_venta);
    }

    @GetMapping("/ventas")
    public List<Venta> listarVentas() {
        return intVentaService.consultarVentas();
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public void editarVenta(@PathVariable long codigo_venta, @RequestBody Venta venta) {
        Venta v = intVentaService.consultarDatosVenta(codigo_venta);
        v.setFecha_venta(venta.getFecha_venta());
        v.setCliente(venta.getCliente());
        v.setTotal(venta.getTotal());
        v.setListaProductos(venta.getListaProductos());
        intVentaService.editarDatosVenta(v);
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> buscarProductosPorVenta(@PathVariable long codigo_venta) {
        Venta v = intVentaService.consultarDatosVenta(codigo_venta);
        List<Producto> productosVenta = new ArrayList<>();
        for (Producto p : v.getListaProductos()) {
            productosVenta.add(p);
        }
        return productosVenta;
    }

    @GetMapping("/ventas/fecha/{fecha_venta}")
    public VentasFechaDTO buscarVentasFecha(@PathVariable LocalDate fecha_venta) {
        return intVentaService.MontosVentasFecha(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public MayorVentaDTO mayorVentaDTO (){
        return intVentaService.DatosMayorVenta();
    }
}