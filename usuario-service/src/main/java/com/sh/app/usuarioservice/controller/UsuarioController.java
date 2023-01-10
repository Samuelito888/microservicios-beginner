/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.usuarioservice.controller;

import com.sh.app.usuarioservice.Service.UsuarioService;
import com.sh.app.usuarioservice.entities.Usuario;
import com.sh.app.usuarioservice.modelos.Moto;
import com.sh.app.usuarioservice.modelos.Vehiculo;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarios);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/vehiculo/{usuarioId}")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculos(@PathVariable("usuarioId") Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        List<Vehiculo> vehiculos = usuarioService.obtenerVehiculosPorUsuarioId(id);
        return ResponseEntity.ok(vehiculos);
    }

    @GetMapping("/moto/{usuarioId}")
    public ResponseEntity<List<Moto>> obtenerMotos(@PathVariable("usuarioId") Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        List<Moto> motos = usuarioService.obtenerMotosPorUsuarioId(id);
        return ResponseEntity.ok(motos);
    }
    //FEIGN CLIENT
    @PostMapping("/vehiculo/{usuarioId}")
    public ResponseEntity<Vehiculo> guardarVehiculos(@PathVariable("usuarioId") Long id, @RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = usuarioService.saveVehiculo(id, vehiculo);
        return ResponseEntity.ok(nuevoVehiculo);
    }

    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") Long id, @RequestBody Moto moto) {
        Moto nuevaMoto = usuarioService.saveMoto(id, moto);
        return ResponseEntity.ok(nuevaMoto);
    }
    
    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String, Object>> listarTodosLosTransportes(@PathVariable("usuarioId") Long id){
        Map<String, Object> res = usuarioService.getUsuarioAndTransporte(id);
        
        return ResponseEntity.ok(res);
    }

}
