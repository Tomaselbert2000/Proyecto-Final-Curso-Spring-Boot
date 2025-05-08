package com.example.proyecto_final_curso_springboot.controller;

import com.example.proyecto_final_curso_springboot.model.Producto;
import com.example.proyecto_final_curso_springboot.service.IntProductoService;
import com.example.proyecto_final_curso_springboot.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IntProductoService intProductoService; // inyectamos dependencias

    // a continuacion definimos las rutas y metodos para cada endpoint

    @PostMapping("/productos/crear")
    public void crearProducto(@RequestBody Producto producto) {
        intProductoService.crearProducto(producto);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable long codigo_producto) {
        intProductoService.eliminarProducto(codigo_producto);
    }

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return intProductoService.buscarProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto buscarProducto(@PathVariable long codigo_producto) {
        return intProductoService.buscarProducto(codigo_producto);
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public void editarProducto(@PathVariable long codigo_producto, @RequestBody Producto producto) {
        Producto p = intProductoService.buscarProducto(codigo_producto);
        p.setNombre(producto.getNombre());
        p.setCosto(producto.getCosto());
        p.setMarca(producto.getMarca());
        p.setCantidad_disponible(producto.getCantidad_disponible());
        intProductoService.editarProducto(p);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock() {
        List<Producto> faltantes= new ArrayList<>();
        for(Producto p : intProductoService.buscarProductos()){
            if (p.getCantidad_disponible() < 5){
                faltantes.add(p);
            }
        }
        return faltantes;
    }

}
