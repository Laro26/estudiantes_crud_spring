package com.neoris.pruebaTecnica.repo;

import com.neoris.pruebaTecnica.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepo extends JpaRepository <Estudiante, Integer>{

}
