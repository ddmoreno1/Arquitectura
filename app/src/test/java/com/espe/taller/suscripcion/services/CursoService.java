/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.taller.suscripcion.services;

import com.espe.taller.suscripcion.models.Curso;
import com.espe.taller.suscripcion.repositories.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso crearCurso(Curso curso) {
        // Validar el número de cursos activos del creador
        Long creadorId = curso.getCreador().getId();
        int cursosActivos = cursoRepository.countByCreadorIdAndEstado(creadorId, "ACTIVO");

        if (cursosActivos >= 2) {
            throw new IllegalStateException("El creador no puede tener más de dos cursos activos.");
        }

        // Guarda el curso si la validación pasa
        return cursoRepository.save(curso);
    }

    public Curso obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
    
}
