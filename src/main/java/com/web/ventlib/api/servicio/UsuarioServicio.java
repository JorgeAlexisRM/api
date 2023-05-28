package com.web.ventlib.api.servicio;

import com.web.ventlib.api.dto.UsuarioRegistroDTO;
import com.web.ventlib.api.entidad.Usuario;

public interface UsuarioServicio {
    
    public Usuario guardarUsuario(UsuarioRegistroDTO registroDTO);
}
