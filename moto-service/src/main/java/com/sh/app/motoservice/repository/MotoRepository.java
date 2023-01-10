/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sh.app.motoservice.repository;

import com.sh.app.motoservice.entities.Moto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
 */
@Repository
public interface MotoRepository extends JpaRepository<Moto, Long>{
    
    List<Moto> findByUsuarioId(Long usuarioId);
    
}
