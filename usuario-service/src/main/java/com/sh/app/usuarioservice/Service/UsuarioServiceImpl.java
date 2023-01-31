/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.usuarioservice.Service;

import com.sh.app.usuarioservice.entities.Usuario;
import com.sh.app.usuarioservice.feignclients.MotoFeignClient;
import com.sh.app.usuarioservice.feignclients.VehiculoFeignClient;
import com.sh.app.usuarioservice.modelos.Moto;
import com.sh.app.usuarioservice.modelos.Vehiculo;
import com.sh.app.usuarioservice.repository.UsuarioRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author shmen
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RestTemplate restTemplate;
 
    @Autowired
    private VehiculoFeignClient vehiculoFeignClient;
    
    @Autowired
    private MotoFeignClient motoFeignClient;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }
    //REST TEMPLATE
    @Override
    public List<Vehiculo> obtenerVehiculosPorUsuarioId(Long id){
        List<Vehiculo> vehiculos = restTemplate.getForObject("http://vehiculo-service/api/vehiculo/usuario/" + id, List.class);
        return vehiculos;
    }
    
    @Override
    public List<Moto> obtenerMotosPorUsuarioId(Long id) {
        List<Moto> motos = restTemplate.getForObject("http://moto-service/api/moto/usuario/" + id, List.class);
        return motos;
    }
    //FEIGN CLIENT
    @Override
    public Vehiculo saveVehiculo(Long id, Vehiculo vehiculo) {
        vehiculo.setUsuarioId(id);
        Vehiculo nuevoVehiculo = vehiculoFeignClient.save(vehiculo);
        
        return nuevoVehiculo;
    }

    @Override
    public Moto saveMoto(Long id, Moto moto) {
        moto.setUsuarioId(id);
        Moto nuevaMoto = motoFeignClient.save(moto);
        
        return nuevaMoto;
    }

    @Override
    public Map<String, Object> getUsuarioAndTransporte(Long id) {
        Map<String, Object> res = new HashMap<>();
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        
        if(usuario == null){
            res.put("Mensaje", "El usuario no existe");
            return res;
        }
        
        res.put("Usuario", usuario);
        
        List<Vehiculo> vehiculo = vehiculoFeignClient.getVehiculos(id);
        
        if(vehiculo == null || vehiculo.isEmpty()){
            res.put("Vehiculos", "El usuario no tiene vehiculos");
        }else{
            res.put("Vehiculos", vehiculo);
        }
        
        List<Moto> moto = motoFeignClient.getMotos(id);
        
        if(moto ==null || moto.isEmpty()){
            res.put("Motos", "El usuario no tiene motos");
        }else{
            res.put("Motos", moto);
        }
        
        return res;
    }
    
}
