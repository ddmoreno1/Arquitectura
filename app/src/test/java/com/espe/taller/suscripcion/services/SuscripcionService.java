/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.taller.suscripcion.services;

import com.espe.taller.suscripcion.models.Suscripcion;
import com.espe.taller.suscripcion.repositories.SuscripcionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
public class SuscripcionService {
    
     @Autowired
    private SuscripcionRepository suscripcionRepository;

    public List<Suscripcion> listarSuscripciones() {
        return suscripcionRepository.findAll();
    }

    public Suscripcion crearSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion obtenerSuscripcionPorId(Long id) {
        return suscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));
    }

    public void eliminarSuscripcion(Long id) {
        suscripcionRepository.deleteById(id);
    }
    
}
