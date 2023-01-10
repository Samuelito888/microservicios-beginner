/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sh.app.usuarioservice.feignclients;

import com.sh.app.usuarioservice.modelos.Vehiculo;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author shmen
 */
@FeignClient(name = "vehiculo-service", url = "http://localhost:8002")
@RequestMapping("/api/vehiculo")
public interface VehiculoFeignClient {
    
    @PostMapping()
    public Vehiculo save(@RequestBody Vehiculo vehiculo);
    
    @GetMapping("/usuario/{usuarioId}")
    public List<Vehiculo> getVehiculos(@PathVariable("usuarioId") Long id);
    
}
