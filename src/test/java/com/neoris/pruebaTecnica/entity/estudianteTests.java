package com.neoris.pruebaTecnica.entity;

import  static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.neoris.pruebaTecnica.repo.EstudianteRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class estudianteTests {
    @Autowired
    private EstudianteRepo estudianteRepo;

    @Test
    @Rollback(false)
    public void testNuevoEstudiante(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Juan");
        estudiante.setApellido("Triana");
        estudiante.setCodigo(234566);
        estudiante.setEmail("juan.triana@gmail.com");
        estudiante.setTelefono("234245456");
        Estudiante estudianteNuevo = estudianteRepo.save(estudiante);
        assertNotNull(estudianteNuevo);
    }

    @Test
    @Rollback(false)
    public void testActualizarEstudiante() {
        String name = "JuanitoManuel";
        Integer id= 15;
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(name);
        estudiante.setCodigo(234567);
        estudiante.setId(id);
        estudianteRepo.save(estudiante);

       Estudiante estudianteActualizado = estudianteRepo.findById(id).get();
       assertThat(estudianteActualizado.getNombre()).isEqualTo(name);
    }

    @Test
    public void testListarEstudiantes(){
        List<Estudiante> listEstudiantes = (List<Estudiante>) estudianteRepo.findAll();
        for(Estudiante estudiante :listEstudiantes){
            System.out.println(estudiante);
        }
        assertThat(listEstudiantes).size().isGreaterThan(0);
    }
    @Test
    @Rollback(false)
    public void testEliminarEstudiante() {
        Integer id=13;
        boolean existeEstudiante= estudianteRepo.findById(id).isPresent();
        estudianteRepo.deleteById(id);
        boolean yaNoExisteEstudiante= estudianteRepo.findById(id).isPresent();
        assertTrue(existeEstudiante);
        assertFalse(yaNoExisteEstudiante);
    }

}
