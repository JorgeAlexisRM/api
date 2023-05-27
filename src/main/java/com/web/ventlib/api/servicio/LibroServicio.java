package com.web.ventlib.api.servicio;

import com.web.ventlib.api.entidad.Libro;
import java.util.List;

public interface LibroServicio {
    
    public List<Libro> listarLibros();

    public Libro guardarLibro(Libro libro);

    public Libro obtenerLibroPorId(Long id);

    /*public List<Libro> findByISBN(Long isbn);*/

    public Libro actualizarLibro(Libro libro);

    public void eliminarLibro(Long id);


    
}
