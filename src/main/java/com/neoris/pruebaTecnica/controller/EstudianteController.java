package com.neoris.pruebaTecnica.controller;

import com.neoris.pruebaTecnica.entity.Estudiante;
import com.neoris.pruebaTecnica.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/listaestudiantes")
    public List<Estudiante> listaEstudiantes(){
        return estudianteService.listEstudiante();
    }

    @PostMapping
    public Estudiante nuevoEstudiante( @RequestBody Estudiante estudiante){
        return estudianteService.nuevoEstudiante(estudiante);
    }
    @PutMapping
    public Estudiante actualizarEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.actualizarEstudiante(estudiante);
    }
    @DeleteMapping
    public void eliminarEstudiante(@RequestBody Estudiante estudiante){
        estudianteService.eliminarEstudiante(estudiante);
    }

}
