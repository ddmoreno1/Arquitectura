/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.taller.suscripcion.controllers;

import com.espe.taller.suscripcion.dto.SuscripcionDTO;
import com.espe.taller.suscripcion.models.Suscripcion;
import com.espe.taller.suscripcion.services.SuscripcionService;
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
@RequestMapping("/api/suscripciones")
public class SuscripcionController {
    
    @Autowired
    private SuscripcionService suscripcionService;

    @GetMapping
    public List<SuscripcionDTO> listarSuscripciones() {
        return suscripcionService.listarSuscripciones().stream().map(suscripcion -> {
            SuscripcionDTO dto = new SuscripcionDTO();
            dto.setId(suscripcion.getId());
            dto.setConsumidorId(suscripcion.getConsumidor().getId());
            dto.setCursoId(suscripcion.getCurso().getId());
            dto.setActiva(suscripcion.isActiva());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Suscripcion> crearSuscripcion(@RequestBody Suscripcion suscripcion) {
        Suscripcion nuevaSuscripcion = suscripcionService.crearSuscripcion(suscripcion);
        return ResponseEntity.ok(nuevaSuscripcion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suscripcion> obtenerSuscripcionPorId(@PathVariable Long id) {
        Suscripcion suscripcion = suscripcionService.obtenerSuscripcionPorId(id);
        return ResponseEntity.ok(suscripcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSuscripcion(@PathVariable Long id) {
        suscripcionService.eliminarSuscripcion(id);
        return ResponseEntity.noContent().build();
    }
    
}
