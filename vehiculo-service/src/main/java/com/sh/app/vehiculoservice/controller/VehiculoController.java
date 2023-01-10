/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.vehiculoservice.controller;

import com.sh.app.vehiculoservice.entities.Vehiculo;
import com.sh.app.vehiculoservice.service.VehiculoService;
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
@RequestMapping("/api/vehiculo")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarVehiculos(){
        List<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
        if(vehiculos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(vehiculos);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculoPorId(@PathVariable("id") Long id){
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        if(vehiculo == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(vehiculo);
    }
    
    @PostMapping
    public ResponseEntity<Vehiculo> guardarVehiculo(@RequestBody Vehiculo vehiculo){
        Vehiculo nuevoVehiculo = vehiculoService.guardarVehiculo(vehiculo);
        
        return ResponseEntity.ok(nuevoVehiculo);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculoPorUsuarioId(@PathVariable("usuarioId") Long id){
        List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculoPorUsuarioId(id);
        if(vehiculos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(vehiculos);
    }
    
}
