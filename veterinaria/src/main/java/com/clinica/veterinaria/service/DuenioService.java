/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.veterinaria.service;

import com.clinica.veterinaria.dto.veterinariaDTO;
import com.clinica.veterinaria.model.Duenio;
import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.repository.DuenioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author moss_
 */
@Service
public class DuenioService implements IDuenioService{
    @Autowired
    private DuenioRepository duenioRepo;

    @Override
    public List<Duenio> getDuenios() {
        List<Duenio>listaDuenios = duenioRepo.findAll();
        return listaDuenios;
        
    }   

    @Override
    public void saveDuenio(Duenio duenio) {
        duenioRepo.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id_duenio) {
        duenioRepo.deleteById(id_duenio);
    }

    @Override
    public Duenio findDuenio(Long id_duenio) {
        return duenioRepo.findById(id_duenio).orElse(null);      
    }

    @Override
    public void editDuenio(Long idOriginal, Long id_duenioNuevo, String nuevodni, String nuevoNombre, String nuevoApellido, Long nuevoCelular) {
       Duenio duenio= this.findDuenio(idOriginal);
        
        //modifico a nivel lógico
        duenio.setId_duenio(id_duenioNuevo);
        duenio.setNombre(nuevoNombre);
        duenio.setApellido(nuevoApellido);
        duenio.setDni(nuevodni);
        duenio.setCelular(idOriginal);
        
        this.saveDuenio(duenio);               
                
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
    }   

    @Override
    public List<veterinariaDTO> listaDTO() {
        List<Duenio> listaDuenios = this.getDuenios();
        List<veterinariaDTO> datos = new ArrayList<>();
        veterinariaDTO vetdto = new veterinariaDTO();
        Mascota mascota;
        String nameMascota,especie,raza,nameDuenio, apeDuenio;             
        
        for(Duenio duenio:listaDuenios){
            //obtebemos la mascota del primer duenio de la listaDuenios
            //extraemos los datos del duenio
            nameDuenio=duenio.getNombre();
            apeDuenio=duenio.getApellido();
            mascota=duenio.getUnaMascota();
            
            //extraemos los datos de una Mascota
            nameMascota=mascota.getNombre();
            especie=mascota.getEspecie();
            raza=mascota.getRaza();            
            
            vetdto.setNombre_duenio(nameDuenio);
            vetdto.setApellido_duenio(apeDuenio);
            vetdto.setNombreMascota(nameMascota);
            vetdto.setEspecie(especie);
            vetdto.setRaza(raza);
            
            datos.add(vetdto);
            vetdto=new veterinariaDTO(); //reseteo           
            
        }
    
        return datos;
    } 
    
}
