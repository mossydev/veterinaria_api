/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author moss_
 */
@Getter @Setter
@Entity
public class Duenio {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_duenio;
    private String dni;
    private String nombre;
    private String apellido;
    private Long celular;
    @OneToOne
    @JoinColumn(name="id_mascota",referencedColumnName="id_mascota")
    private Mascota unaMascota;

    public Duenio() {
    }

    public Duenio(Long id_duenio, String dni, String nombre, String apellido, Long celular, Mascota unaMascota) {
        this.id_duenio = id_duenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.unaMascota = unaMascota;
    }

  
    
}
