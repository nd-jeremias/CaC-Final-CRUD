package com.cac.trabajofinal.domain;

public class Usuarios {
    
    private Long id;
    private String user;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String email;
    private String password;

    public Usuarios () {
        
    }
    
    public Usuarios(Long id, String user, String nombre, String apellido, Long telefono, String email, String password) {
        this.id = id;
        this.user = user;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Usuarios(String user, String nombre, String apellido, Long telefono, String email, String password) {
        this.user = user;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
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

    public String toString() {
        return "Usuario: [id:" + id + ",user:" + user + ", nombre:" + nombre + ", apellido:" + apellido +  ",telefono:" + telefono + ", email:" + email +  ",password:" + password + "]";
    }
}
