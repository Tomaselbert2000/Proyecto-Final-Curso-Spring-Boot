package com.example.proyecto_final_curso_springboot.service;

import com.example.proyecto_final_curso_springboot.dto.MayorVentaDTO;
import com.example.proyecto_final_curso_springboot.dto.VentasFechaDTO;
import com.example.proyecto_final_curso_springboot.model.Venta;
import com.example.proyecto_final_curso_springboot.repository.IntVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service // mapeamos como servicio
public class VentaService implements IntVentaService{ // implementamos la interfaz de Venta

    @Autowired
    // inyectamos dependencias del repositorio para acceder a los metodos de CRUD
    private IntVentaRepository intVentaRepository;

    @Override
    public void crearVenta(Venta venta) {
        intVentaRepository.save(venta);
    }

    @Override
    public void eliminarVenta(long id) {
        intVentaRepository.deleteById(id);
    }

    @Override
    public void editarDatosVenta(Venta venta) {
        this.crearVenta(venta);
    }

    @Override
    public Venta consultarDatosVenta(long id) {
        return intVentaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venta> consultarVentas() {
        return intVentaRepository.findAll();
    }

    @Override
    public VentasFechaDTO MontosVentasFecha(LocalDate fecha) {

        VentasFechaDTO resultados = new VentasFechaDTO(); // creamos un objeto DTO nuevo, sin valores
        List<Venta> ventasPorFecha = new ArrayList<>(); // creamos una lista vacia para almacenar las ventas de una determinada fecha
        double totalPorFecha = 0; // este acumulador va a guardar el monto total de todas las ventas
        int contador = 0; // este contado va a guardar la cantidad de ventas de una determinada fecha

        for(Venta venta : intVentaRepository.findAll()){ // recorremos el array de todas las ventas
            if(venta.getFecha_venta().equals(fecha)){ // evaluamos que la fecha de la venta coincida con la que recibimos como parametro
                ventasPorFecha.add(venta); // si se cumple la condicion, agregamos esa venta al array de ventas por fecha
            }
        }

        for(Venta venta : ventasPorFecha){ // recorremos el array de ventas por fecha
            totalPorFecha+=venta.getTotal(); // al acumulador del monto total le sumamos el valor del monto de cada fecha encontrada
            contador++; // incrementamos en 1 al contador para saber la cantidad de ventas
        }
        // le asignamos los valores encontrados al objeto DTO que creamos al principio
        resultados.setTotalVentas(totalPorFecha);
        resultados.setCantidadVentas(contador);

        return resultados; // retornamos el objeto
    }

    @Override
    public Venta MayorMonto() {
        Venta MayorVentaPorTotal = new Venta(); // definimos un objeto de clase Venta, vacío
        double mayorTotal = 0; // definimos un valor para el mayor total, inicializado en 0
        for(Venta venta : intVentaRepository.findAll()){ // recorremos el array de todas las ventas
            if(venta.getTotal() > mayorTotal){ // comparamos si el total de la venta es mayor al valor de referencia
                mayorTotal = venta.getTotal(); // si la condicion se cumple, ese valor es asignado a la variable de referencia
                MayorVentaPorTotal = venta; // esa venta pasa a ser la venta con mayor total
            }
        }
        return MayorVentaPorTotal; // retornamos la mayor venta
    }

    @Override
    public MayorVentaDTO DatosMayorVenta() {
        MayorVentaDTO resultados = new MayorVentaDTO(); // creamos un objeto DTO vacío
        Venta MayorVentaDatos = this.MayorMonto(); // llamamos al metodo dentro de esta misma clase para obtener la mayor venta por monto

        // al objeto DTO creado le asignamos los datos de la venta y su cliente asociado
        resultados.setCodigo_venta(MayorVentaDatos.getCodigo_venta());
        resultados.setTotal_venta(MayorVentaDatos.getTotal());
        resultados.setCantidad_productos(MayorVentaDatos.getListaProductos().size());
        resultados.setNombre_cliente(MayorVentaDatos.getCliente().getNombre());
        resultados.setApellido_cliente(MayorVentaDatos.getCliente().getApellido());

        return resultados; // retornamos el DTO como resultado
    }
}
