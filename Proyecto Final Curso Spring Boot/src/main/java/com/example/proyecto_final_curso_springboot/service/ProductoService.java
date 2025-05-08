package com.example.proyecto_final_curso_springboot.service;

import com.example.proyecto_final_curso_springboot.model.Producto;
import com.example.proyecto_final_curso_springboot.repository.IntProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // mapeamos como servicio
public class ProductoService implements IntProductoService{ // implementamos la interfaz de Producto

    @Autowired // inyectamos dependencias del repositorio para acceder a los metodos de CRUD
    private IntProductoRepository intProductoRepository;

    @Override
    public void crearProducto(Producto producto) {
        intProductoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(long id) {
        intProductoRepository.deleteById(id);
    }

    @Override
    public void editarProducto(Producto producto) {
        this.crearProducto(producto);
    }

    @Override
    public Producto buscarProducto(long id) {
        return intProductoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> buscarProductos() {
        return intProductoRepository.findAll();
    }
}
