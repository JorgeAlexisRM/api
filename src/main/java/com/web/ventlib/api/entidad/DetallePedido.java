package com.web.ventlib.api.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="detallePedido")
public class DetallePedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idDetalle;

    private String nombre;
    private int cantidad;
    private double precio;
    private double total;

    @ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Libro libro;
    
    public DetallePedido() {
    }

    public DetallePedido(long idDetalle, String nombre, int cantidad, double precio, double total) {
        this.idDetalle = idDetalle;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "DetallePedido [idDetalle=" + idDetalle + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio="
                + precio + ", total=" + total + "]";
    }

    

}
