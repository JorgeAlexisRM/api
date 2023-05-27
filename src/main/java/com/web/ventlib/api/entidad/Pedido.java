package com.web.ventlib.api.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idPedido;

    private long idUsuario;
    private String fecha;
    private String tipoEnvio;
    private float costoEnvio;
    private String estado;
    
    public Pedido(long idPedido, long idUsuario, String fecha, String tipoEnvio, float costoEnvio, String estado) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.tipoEnvio = tipoEnvio;
        this.costoEnvio = costoEnvio;
        this.estado = estado;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public float getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
