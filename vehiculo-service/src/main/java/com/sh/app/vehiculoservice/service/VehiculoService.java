/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sh.app.vehiculoservice.service;

import com.sh.app.vehiculoservice.entities.Vehiculo;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface VehiculoService {
    
    public List<Vehiculo> listarVehiculos();
    
    public Vehiculo obtenerVehiculoPorId(Long id);
    
    public Vehiculo guardarVehiculo(Vehiculo vehiculo);
    
    public List<Vehiculo> obtenerVehiculoPorUsuarioId(Long id);
    
}
