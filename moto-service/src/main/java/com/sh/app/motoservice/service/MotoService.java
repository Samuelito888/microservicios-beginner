/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sh.app.motoservice.service;

import com.sh.app.motoservice.entities.Moto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface MotoService {
    
    public List<Moto> listarMotos();
    
    public Moto obtenerMotoPorId(Long id);
    
    public Moto guardarMoto(Moto moto);
    
    public List<Moto> obtenerMotoPorUsuarioId(Long id);
    
}
