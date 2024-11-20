/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.taller.suscripcion.controllers;

import com.espe.taller.suscripcion.dto.CursoDTO;
import com.espe.taller.suscripcion.models.Curso;
import com.espe.taller.suscripcion.services.CursoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDTO> listarCursos() {
        return cursoService.listarCursos().stream().map(curso -> {
            CursoDTO dto = new CursoDTO();
            dto.setId(curso.getId());
            dto.setNombre(curso.getNombre());
            dto.setDescripcion(curso.getDescripcion());
            dto.setEstado(curso.getEstado());
            dto.setCreadorId(curso.getCreador().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.ok(nuevoCurso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Long id) {
        Curso curso = cursoService.obtenerCursoPorId(id);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
    
}
