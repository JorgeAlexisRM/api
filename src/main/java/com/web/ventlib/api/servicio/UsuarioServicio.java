package com.web.ventlib.api.servicio;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.web.ventlib.api.dto.UsuarioRegistroDTO;
import com.web.ventlib.api.entidad.Usuario;

public interface UsuarioServicio extends UserDetailsService{
    
    public Usuario guardarUsuario(UsuarioRegistroDTO registroDTO);
}
