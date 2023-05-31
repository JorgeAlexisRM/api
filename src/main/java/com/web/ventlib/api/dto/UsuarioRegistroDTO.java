package com.web.ventlib.api.dto;

public class UsuarioRegistroDTO {

    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;
    private int codigoPostal;
    private String pais;
    private String email;
    private String password;
    
    public UsuarioRegistroDTO() {
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }

    public UsuarioRegistroDTO(String nombre, String apellidos, String direccion, String localidad, int codigoPostal,
            String pais, String email, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(Long idUsuario, String nombre, String apellidos, String direccion, String localidad,
            int codigoPostal, String pais, String email, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.email = email;
        this.password = password;
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

    
}
