package com.web.ventlib.api.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ventlib.api.entidad.Libro;
import com.web.ventlib.api.repositorio.LibroRepositorio;

@Service
public class LibroServicioImpl implements LibroServicio{

    @Autowired
    private LibroRepositorio repositorio;

    @Override
    public List<Libro> listarLibros(String palabraClave) {
        if(palabraClave != null){
            return repositorio.findAll(palabraClave);
        }
        return repositorio.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return repositorio.save(libro);
    }
   
    @Override
    public Libro actualizarLibro(Libro libro) {
        return repositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Optional<Libro> get(Long id) {
        return repositorio.findById(id);
    }

    
    
}
