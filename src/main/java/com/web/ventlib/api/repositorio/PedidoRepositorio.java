package com.web.ventlib.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.ventlib.api.entidad.Pedido;
import com.web.ventlib.api.entidad.Usuario;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido,Long>{
    List<Pedido> findByUsuario (Usuario usuario);
}
