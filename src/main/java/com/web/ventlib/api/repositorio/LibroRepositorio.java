package com.web.ventlib.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.ventlib.api.entidad.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Long>{
    
}
