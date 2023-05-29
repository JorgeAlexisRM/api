package com.web.ventlib.api.servicio;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.web.ventlib.api.dto.UsuarioRegistroDTO;
import com.web.ventlib.api.entidad.Usuario;

public interface UsuarioServicio extends UserDetailsService{
    
    Optional<Usuario> findById(Long id);
    public Usuario guardarUsuario(UsuarioRegistroDTO registroDTO);
    Optional<Usuario> findByEmail(String email);
}
