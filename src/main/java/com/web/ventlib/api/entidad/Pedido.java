package com.web.ventlib.api.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idPedido;

    private String numeroOrd;
    private double total;
    private Date fecha;
    private String estado;

    @ManyToOne
    private Usuario usuario;
    
    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detalle;

    public Pedido() {
    }

    public Pedido(long idPedido, String numeroOrd, double total, Date fecha, String estado) {
        this.idPedido = idPedido;
        this.numeroOrd = numeroOrd;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
    }



    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumeroOrd() {
        return numeroOrd;
    }

    public void setNumeroOrd(String numeroOrd) {
        this.numeroOrd = numeroOrd;
    }  

    public List<DetallePedido> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetallePedido> detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", numeroOrd=" + numeroOrd + ", total=" + total + ", fecha=" + fecha
                + ", estado=" + estado + "]";
    }




    
    
}
