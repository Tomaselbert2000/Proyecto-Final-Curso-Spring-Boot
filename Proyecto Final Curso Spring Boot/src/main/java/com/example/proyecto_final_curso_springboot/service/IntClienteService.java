package com.example.proyecto_final_curso_springboot.service;

import com.example.proyecto_final_curso_springboot.model.Cliente;

import java.util.List;
// definimos los metodos necesarios para poder realizar CRUD de clientes en la base de datos
public interface IntClienteService {

    public void crearCliente(Cliente cliente);
    public void eliminarCliente(long id);
    public void editarCliente(Cliente cliente);
    public Cliente buscarClientePorId(long id);
    public List<Cliente> buscarClientes();
}
