/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sh.app.usuarioservice.feignclients;

import com.sh.app.usuarioservice.modelos.Moto;
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
@FeignClient(name = "moto-service")
@RequestMapping("/api/moto")
public interface MotoFeignClient {
    
    @PostMapping()
    public Moto save(@RequestBody Moto vehiculo);
    
    @GetMapping("/usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") Long id);
    
}
