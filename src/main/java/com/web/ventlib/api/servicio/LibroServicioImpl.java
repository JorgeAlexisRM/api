package com.web.ventlib.api.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ventlib.api.entidad.Libro;
import com.web.ventlib.api.repositorio.LibroRepositorio;

@Service
public class LibroServicioImpl implements LibroServicio{

    @Autowired
    private LibroRepositorio repositorio;

    @Override
    public List<Libro> listarLibros() {
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

   /* @Override
    public List<Libro> findByISBN(Long isbn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByISBN'");
    }*/

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return repositorio.findById(id).get();
    }

    
    
    
    
}
