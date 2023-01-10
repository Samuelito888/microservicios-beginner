/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sh.app.usuarioservice.Service;

import com.sh.app.usuarioservice.entities.Usuario;
import com.sh.app.usuarioservice.modelos.Moto;
import com.sh.app.usuarioservice.modelos.Vehiculo;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shmen
 */
public interface UsuarioService {
    
    public List<Usuario> listarUsuarios();
    
    public Usuario obtenerUsuarioPorId(Long id);
    
    public Usuario guardarUsuario(Usuario usuario);
    //REST TEMPLATE
    public List<Vehiculo> obtenerVehiculosPorUsuarioId(Long id);
    
    public List<Moto> obtenerMotosPorUsuarioId(Long id);
    //FEIGN CLIENT
    public Vehiculo saveVehiculo(Long id, Vehiculo vehiculo);
    
    public Moto saveMoto(Long id, Moto moto);
    
    public Map<String, Object> getUsuarioAndTransporte(Long id);        
    
}
