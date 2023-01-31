/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.usuarioservice.controller;

import com.sh.app.usuarioservice.Service.UsuarioService;
import com.sh.app.usuarioservice.entities.Usuario;
import com.sh.app.usuarioservice.modelos.Moto;
import com.sh.app.usuarioservice.modelos.Vehiculo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @CircuitBreaker(name = "vehiculosCB", fallbackMethod = "fallBackGetVehiculos")
    @GetMapping("/vehiculo/{usuarioId}")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculos(@PathVariable("usuarioId") Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        List<Vehiculo> vehiculos = usuarioService.obtenerVehiculosPorUsuarioId(id);
        return ResponseEntity.ok(vehiculos);
    }

    @CircuitBreaker(name = "motosCB", fallbackMethod = "fallBackGetMotos")
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
    @CircuitBreaker(name = "vehiculosCB", fallbackMethod = "fallBackSaveVehiculos")
    @PostMapping("/vehiculo/{usuarioId}")
    public ResponseEntity<Vehiculo> guardarVehiculos(@PathVariable("usuarioId") Long id, @RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = usuarioService.saveVehiculo(id, vehiculo);
        return ResponseEntity.ok(nuevoVehiculo);
    }

    @CircuitBreaker(name = "motosCB", fallbackMethod = "fallBackSaveMotos")
    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") Long id, @RequestBody Moto moto) {
        Moto nuevaMoto = usuarioService.saveMoto(id, moto);
        return ResponseEntity.ok(nuevaMoto);
    }

    @CircuitBreaker(name = "todosCB", fallbackMethod = "fallBackGetTodos")
    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String, Object>> listarTodosLosTransportes(@PathVariable("usuarioId") Long id) {
        Map<String, Object> res = usuarioService.getUsuarioAndTransporte(id);

        return ResponseEntity.ok(res);
    }

    //CIRCUIT BREAKER RESPALDO
    private ResponseEntity<List<Vehiculo>> fallBackGetVehiculos(@PathVariable("usuarioId") Long id, RuntimeException rex) {
        return new ResponseEntity("El usuario: " + id + "tiene los carros en el taller.", HttpStatus.OK);
    }

    private ResponseEntity<List<Moto>> fallBackGetMotos(@PathVariable("usuarioId") Long id, RuntimeException rex) {
        return new ResponseEntity("El usuario: " + id + "tiene las motos en el taller.", HttpStatus.OK);
    }

    public ResponseEntity<Vehiculo> fallBackSaveVehiculos(@PathVariable("usuarioId") Long id, @RequestBody Vehiculo vehiculo, RuntimeException rex) {
        return new ResponseEntity("El usuario: " + id + "no tiene dinero para los carros.", HttpStatus.OK);
    }

    public ResponseEntity<Moto> fallBackSaveMotos(@PathVariable("usuarioId") Long id, @RequestBody Moto moto, RuntimeException rex) {
        return new ResponseEntity("El usuario: " + id + "no tiene dinero para las motos.", HttpStatus.OK);
    }

    private ResponseEntity<Map<String, Object>> fallBackGetTodos(@PathVariable("usuarioId") Long id, RuntimeException rex) {
        return new ResponseEntity("El usuario: " + id + "tiene todos los vehiculos en el taller.", HttpStatus.OK);
    }

}
