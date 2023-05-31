package com.web.ventlib.api.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ventlib.api.entidad.DetallePedido;
import com.web.ventlib.api.repositorio.DetallePedidoRepositorio;

@Service
public class DetallePedidoServicioImpl implements DetallePedidoServicio{

    @Autowired
    DetallePedidoRepositorio repositorio;

    @Override
    public DetallePedido guardarDetallePedido(DetallePedido detallePedido) {
        return repositorio.save(detallePedido);
    }

    
}
