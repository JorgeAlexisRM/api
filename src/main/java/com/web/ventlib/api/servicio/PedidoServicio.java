package com.web.ventlib.api.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ventlib.api.entidad.Pedido;
import com.web.ventlib.api.repositorio.PedidoRepositorio;

@Service
public class PedidoServicio {
    
    @Autowired
    private PedidoRepositorio repositorio;

    public Pedido guardarPedido(Pedido pedido) {
        return repositorio.save(pedido);
    }
   
    public Pedido actualizarPedido(Pedido pedido) {
        return repositorio.save(pedido);
    }

    public void eliminarPedido(Long id) {
        repositorio.deleteById(id);
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return repositorio.findById(id).get();
    }

}
