package com.web.ventlib.api.servicio;

import java.util.List;
import java.util.Optional;

import com.web.ventlib.api.entidad.Pedido;
import com.web.ventlib.api.entidad.Usuario;

public interface PedidoServicio {
    List<Pedido> findAll();
	Optional<Pedido> findById(Long id);
	Pedido save (Pedido orden);
	String generarNumeroOrden();
	List<Pedido> findByUsuario (Usuario usuario);

}
