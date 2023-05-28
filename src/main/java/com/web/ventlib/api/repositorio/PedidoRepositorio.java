package com.web.ventlib.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.ventlib.api.entidad.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido,Long>{
    
}