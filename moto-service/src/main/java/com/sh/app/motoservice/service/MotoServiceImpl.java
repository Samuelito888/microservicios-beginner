/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.motoservice.service;

import com.sh.app.motoservice.entities.Moto;
import com.sh.app.motoservice.repository.MotoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class MotoServiceImpl implements MotoService{
    
    @Autowired
    private MotoRepository motoRepository;

    @Override
    public List<Moto> listarMotos() {
        return motoRepository.findAll();
    }

    @Override
    public Moto obtenerMotoPorId(Long id) {
        return motoRepository.findById(id).orElse(null);
    }

    @Override
    public Moto guardarMoto(Moto moto) {
        Moto nuevaMoto = motoRepository.save(moto);
        return nuevaMoto;
    }

    @Override
    public List<Moto> obtenerMotoPorUsuarioId(Long id) {
        return motoRepository.findByUsuarioId(id);
    }
    
}
