package com.web.ventlib.api.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="libros")
public class Libro {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLibro;

    private String titutlo;
    private String autor;
    private Long isbn;
    private float precio;

    public Libro(Long idLibro, String titutlo, String autor, Long isbn, float precio) {
        this.idLibro = idLibro;
        this.titutlo = titutlo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitutlo() {
        return titutlo;
    }

    public void setTitutlo(String titutlo) {
        this.titutlo = titutlo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    } 
    
}
