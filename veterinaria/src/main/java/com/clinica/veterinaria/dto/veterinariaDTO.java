/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.veterinaria.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author moss_
 */
@Getter @Setter
public class veterinariaDTO {
    private String nombreMascota;    
    private String especie;
    private String raza;
    private String nombre_duenio;
    private String apellido_duenio;

    public veterinariaDTO() {
    }

    public veterinariaDTO(String nombreMascota, String especie, String raza, String nombre_duenio, String apellido_duenio) {
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.nombre_duenio = nombre_duenio;
        this.apellido_duenio = apellido_duenio;
    }       
}
