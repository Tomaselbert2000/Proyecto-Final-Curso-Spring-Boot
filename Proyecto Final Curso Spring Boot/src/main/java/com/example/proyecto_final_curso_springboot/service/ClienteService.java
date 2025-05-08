package com.example.proyecto_final_curso_springboot.service;

import com.example.proyecto_final_curso_springboot.model.Cliente;
import com.example.proyecto_final_curso_springboot.repository.IntClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IntClienteService{ // implementamos la interfaz de Cliente

    @Autowired
    private IntClienteRepository intClienteRepository; // inyectamos dependencias para acceder a los metodos de CRUD

    @Override
    public void crearCliente(Cliente cliente) {
        intClienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(long id) {
        intClienteRepository.deleteById(id);
    }


    @Override
    public void editarCliente(Cliente cliente) {
        this.crearCliente(cliente);
    }

    @Override
    public Cliente buscarClientePorId(long id) {
        return intClienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> buscarClientes() {
        return intClienteRepository.findAll();
    }
}
