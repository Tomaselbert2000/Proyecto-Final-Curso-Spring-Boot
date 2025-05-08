package com.example.proyecto_final_curso_springboot.controller;

import com.example.proyecto_final_curso_springboot.model.Cliente;
import com.example.proyecto_final_curso_springboot.service.IntClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IntClienteService intClienteService; // inyectamos dependencias

    // a continuacion definimos las rutas y metodos para cada endpoint

    @PostMapping("/clientes/crear")
    public void crearCliente(@RequestBody Cliente cliente) {
        intClienteService.crearCliente(cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente) {
        intClienteService.eliminarCliente(id_cliente);
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente buscarCliente(@PathVariable Long id_cliente) {
        return intClienteService.buscarClientePorId(id_cliente);
    }

    @GetMapping("/clientes")
    public List<Cliente> buscarClientes() {
        return intClienteService.buscarClientes();
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public void editarCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {
        Cliente c = intClienteService.buscarClientePorId(id_cliente);
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setDni(cliente.getDni());
        intClienteService.editarCliente(c);
    }
}