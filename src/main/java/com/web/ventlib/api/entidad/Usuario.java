package com.web.ventlib.api.entidad;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name="usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    private String direccion;
    private String localidad;
    private int codigoPostal;
    private String pais;
    private String email;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Libro> libros;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="usuarios_roles", 
        joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "idUsuario"),
        inverseJoinColumns = @JoinColumn(name="rol_id",referencedColumnName = "id"))
    private Collection<Rol> roles;


    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String apellidos, String direccion, String localidad,
            int codigoPostal, String pais, String email, String password, Collection<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(String nombre, String apellidos, String direccion, String localidad,
            int codigoPostal, String pais, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
                + direccion + ", localidad=" + localidad + ", codigoPostal=" + codigoPostal + ", pais=" + pais
                + ", email=" + email + ", password=" + password + "]";
    }

    
    
}
