package com.web.ventlib.api.entidad;

import jakarta.persistence.Column;
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

    @Column(nullable = false)
    private String titulo;
   
    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private Long isbn;

    @Column(nullable = false)
    private Double precio;

    

    public Libro() {
    }

    public Libro(String titulo, String autor, Long isbn, Double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
    }

    public Libro(Long idLibro, String titulo, String autor, Long isbn, Double precio) {
        this.idLibro = idLibro;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    } 
    
}
