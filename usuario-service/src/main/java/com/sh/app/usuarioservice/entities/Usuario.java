/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.usuarioservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "inc_seqUsu", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "inc_seqUsu", sequenceName = "USUARIO_INC", initialValue = 1, allocationSize = 1)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "email")
    private String email;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
