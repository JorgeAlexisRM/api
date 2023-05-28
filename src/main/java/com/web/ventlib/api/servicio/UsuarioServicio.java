package com.web.ventlib.api.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ventlib.api.entidad.Usuario;
import com.web.ventlib.api.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio repositorio;

    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }
   
    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        repositorio.deleteById(id);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return repositorio.findById(id).get();
    }

}
