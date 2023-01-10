/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.motoservice.controller;

import com.sh.app.motoservice.entities.Moto;
import com.sh.app.motoservice.service.MotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/moto")
public class MotoController {
    
    @Autowired
    private MotoService motoService;
    
    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos(){
        List<Moto> motos = motoService.listarMotos();
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(motos);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMotoPorId(@PathVariable("id") Long id){
        Moto moto = motoService.obtenerMotoPorId(id);
        if(moto == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(moto);
    }
    
    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
        Moto nuevaMoto = motoService.guardarMoto(moto);
        
        return ResponseEntity.ok(nuevaMoto);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> obtenerMotoPorUsuarioId(@PathVariable("usuarioId") Long id){
        List<Moto> motos = motoService.obtenerMotoPorUsuarioId(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(motos);
    }
    
    
}
