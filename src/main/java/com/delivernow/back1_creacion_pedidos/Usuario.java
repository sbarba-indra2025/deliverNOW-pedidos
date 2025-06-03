package com.delivernow.back1creacionpedidos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return username;
    }

    public void setNombreUsuario(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return password;
    }

    public void setContrasena(String password) {
        this.password = password;
    }
}
