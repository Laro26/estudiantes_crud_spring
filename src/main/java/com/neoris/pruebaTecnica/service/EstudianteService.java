package com.neoris.pruebaTecnica.service;

import com.neoris.pruebaTecnica.entity.Estudiante;
import com.neoris.pruebaTecnica.repo.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepo estudianteRepo;

    public Estudiante nuevoEstudiante(Estudiante estudiante){
        return estudianteRepo.save(estudiante);
    }
    public Estudiante actualizarEstudiante(Estudiante estudiante){
        return estudianteRepo.save(estudiante);
    }

    public List<Estudiante> listEstudiante(){
        return estudianteRepo.findAll();
    }

    public void eliminarEstudiante(Estudiante estudiante){
        estudianteRepo.deleteById(estudiante.getId());
    }
}
