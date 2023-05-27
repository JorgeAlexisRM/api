package com.web.ventlib.api.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="detallePedido")
public class DetallePedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idDetalle;
    
    private long idPedido;
    private long idLibro;
    private int cantidad;
    private String empaquetado;
    private String estado;
    
    public DetallePedido(long idDetalle, long idPedido, long idLibro, int cantidad, String empaquetado, String estado) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idLibro = idLibro;
        this.cantidad = cantidad;
        this.empaquetado = empaquetado;
        this.estado = estado;
    }

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(long idLibro) {
        this.idLibro = idLibro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEmpaquetado() {
        return empaquetado;
    }

    public void setEmpaquetado(String empaquetado) {
        this.empaquetado = empaquetado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
