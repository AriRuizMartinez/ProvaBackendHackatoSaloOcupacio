package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Models.Actividad;
import com.example.demo.Models.Usuario;
import com.example.demo.Services.ActividadService;
import com.example.demo.Services.UsuarioService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/appActivitats")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;
    @Autowired
    private UsuarioService usuarioService;

    // Crear una nueva actividad
    @PostMapping("/actividad")
    public ResponseEntity<Actividad> crearActividad(@RequestBody Actividad actividad) {
        Actividad nuevaActividad = actividadService.crearActividad(actividad);
        return ResponseEntity.ok(nuevaActividad);
    }

    // Consultar actividades
    @GetMapping("/actividades")
    public ResponseEntity<List<Actividad>> obtenerActividades() {
        List<Actividad> actividades = actividadService.obtenerActividades();
        return ResponseEntity.ok(actividades);
    }

    // Consultar información de una actividad específica
    @GetMapping("/actividades/{id}")
    public ResponseEntity<Actividad> obtenerActividad(@PathVariable Long id) {
        Actividad actividad = actividadService.obtenerActividad(id);
        return ResponseEntity.ok(actividad);
    }

    // Exportar actividades en formato JSON
    @GetMapping("/actividades/exportar")
    public ResponseEntity<List<Actividad>> exportarActividades(HttpServletResponse response) {
    	response.setContentType("application/json");
        response.setHeader("Content-Disposition", "attachment;filename=export.json");
        
        List<Actividad> actividades = actividadService.obtenerActividades();
        
        // Convertir los datos a JSON usando ObjectMapper (de la librería Jackson)
        ObjectMapper mapper = new ObjectMapper();
        
        // Escribir el JSON en la respuesta
        try {
			mapper.writeValue(response.getOutputStream(), actividades);
			return ResponseEntity.ok(actividades);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.internalServerError().build();
    }

    // Importar actividades desde un JSON
    @PostMapping("/actividades/crear")
    public ResponseEntity<Void> importarActividades(@RequestBody List<Actividad> actividades) {
        actividadService.importarActividades(actividades);
        return ResponseEntity.noContent().build();
    }
    
    // Importar actividades desde un archivo JSON
    @PostMapping("/actividades/importar")    
    public ResponseEntity<Void> importarActividades1(@RequestParam("file") MultipartFile file) {
    	// Verificamos si el archivo está vacío
        if (file.isEmpty()) 
            return ResponseEntity.badRequest().build();
        
        // Leer el archivo JSON y convertirlo en una lista de objetos Actividad
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Aquí suponemos que el archivo contiene una lista de actividades en formato JSON
        List<Actividad> actividades;
		try {
			actividades = Arrays.asList(objectMapper.readValue(file.getInputStream(), Actividad[].class));
			
	        // Aquí podrías hacer algo con los datos importados, como guardarlos en la base de datos
	        for (Actividad actividad : actividades) {
	            actividadService.crearActividad(actividad); 
	        }

	        return ResponseEntity.ok().build();
	        
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return ResponseEntity.badRequest().build();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		return ResponseEntity.internalServerError().build();
    }
    
    // Inscribirse en una actividad
    @PostMapping("/{usuarioId}/inscribir/{actividadId}")
    public ResponseEntity<Void> inscribirUsuario(@PathVariable Long usuarioId, @PathVariable Long actividadId) {
    	Actividad actividad = actividadService.obtenerActividad(actividadId);
    	Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
        if(actividad == null || usuario == null) 
        	return ResponseEntity.badRequest().build();
        actividadService.inscribirUsuario(usuario, actividad);
        return ResponseEntity.ok().build();
    }
}

