/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sh.app.vehiculoservice.repository;

import com.sh.app.vehiculoservice.entities.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
 */
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{
    
    List<Vehiculo> findByUsuarioId(Long usuarioId);
    
}
