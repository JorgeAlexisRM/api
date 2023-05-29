package com.web.ventlib.api.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String isbn;

    @Column(nullable = false)
    private Double precio;

    

    public Libro() {
    }

    public Libro(String titulo, String autor, String isbn, Double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
    }

    public Libro(Long idLibro, String titulo, String autor, String isbn, Double precio) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    } 
    
}
