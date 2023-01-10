/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.motoservice.entities;

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
@Table(name = "MOTOS")
public class Moto implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "inc_seqMot", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "inc_seqMot", sequenceName = "MOTO_INC", initialValue = 1, allocationSize = 1)
    private Long id;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "usuarioId")
    private Long usuarioId;

    public Moto() {
    }

    public Moto(Long id, String marca, String modelo, Long usuarioId) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
 
    
    
}
