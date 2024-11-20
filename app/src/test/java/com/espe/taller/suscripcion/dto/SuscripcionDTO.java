/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.taller.suscripcion.dto;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author USER
 */
public class SuscripcionDTO {
    
    private Long id;

    @NotNull
    private Long consumidorId;

    @NotNull
    private Long cursoId;

    @NotNull
    private boolean activa;

    // Getters y Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConsumidorId() {
        return consumidorId;
    }

    public void setConsumidorId(Long consumidorId) {
        this.consumidorId = consumidorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
}
