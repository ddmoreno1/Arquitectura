/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.espe.taller.suscripcion.repositories;

import com.espe.taller.suscripcion.models.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USER
 */
public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
    
}
