package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Actividad;
import com.example.demo.Models.Usuario;
import com.example.demo.Repositories.IActividadRepository;
import com.example.demo.Repositories.IUsuarioRepository;

import java.util.List;

@Service
public class ActividadService {

    @Autowired
    private IActividadRepository actividadRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public List<Actividad> obtenerActividades() {
        return actividadRepository.findAll();
    }

    public Actividad obtenerActividad(Long id) {
        return actividadRepository.findById(id).orElse(null);
    }

    public void importarActividades(List<Actividad> actividades) {
        actividadRepository.saveAll(actividades);
    }
    
    public void inscribirUsuario(Usuario usuario, Actividad actividad ) {
    	usuario.getActividades().add(actividad);
    	usuarioRepository.save(usuario);
    }
}

