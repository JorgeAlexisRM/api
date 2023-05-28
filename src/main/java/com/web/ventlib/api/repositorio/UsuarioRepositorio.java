package com.web.ventlib.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.ventlib.api.entidad.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    
}
