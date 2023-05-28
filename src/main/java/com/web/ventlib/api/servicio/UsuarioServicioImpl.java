package com.web.ventlib.api.servicio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ventlib.api.dto.UsuarioRegistroDTO;
import com.web.ventlib.api.entidad.Rol;
import com.web.ventlib.api.entidad.Usuario;
import com.web.ventlib.api.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario guardarUsuario(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),registroDTO.getApellidos(),
        registroDTO.getDireccion(),registroDTO.getLocalidad(),registroDTO.getCodigoPostal(),
        registroDTO.getCiudad(),registroDTO.getEmail(),registroDTO.getPassword(),
        Arrays.asList(new Rol("ROLE_USER")));

        return usuarioRepositorio.save(usuario);
    }
    
}
