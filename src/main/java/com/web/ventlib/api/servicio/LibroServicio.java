package com.web.ventlib.api.servicio;

import com.web.ventlib.api.entidad.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroServicio {
    
    public List<Libro> listarLibros(String palabraClave);

    public Libro guardarLibro(Libro libro);

    public Libro obtenerLibroPorId(Long id);

    public Libro actualizarLibro(Libro libro);

    public void eliminarLibro(Long id);

    public Optional<Libro> get(Long id);


    
}
