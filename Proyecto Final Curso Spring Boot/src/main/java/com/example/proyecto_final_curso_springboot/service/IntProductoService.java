package com.example.proyecto_final_curso_springboot.service;

import com.example.proyecto_final_curso_springboot.model.Producto;

import java.util.List;
// definimos los metodos necesarios para realizar CRUD de Productos en la base de datos
public interface IntProductoService {

    public void crearProducto(Producto producto);
    public void eliminarProducto(long id);
    public void editarProducto(Producto producto);
    public Producto buscarProducto(long id);
    public List<Producto> buscarProductos();
}
