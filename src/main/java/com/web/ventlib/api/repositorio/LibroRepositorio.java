package com.web.ventlib.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.ventlib.api.entidad.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Long>{

    @Query("SELECT l FROM Libro l WHERE "
    + "CONCAT(l.titulo,l.autor,l.isbn) "
    + " LIKE %?1%")
    public List<Libro> findAll(String palabraClave);

}
