/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.veterinaria.service;

import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.repository.MascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author moss_
 */
@Service
public class MascotaService implements IMascotaService{
    @Autowired
    private MascotaRepository mascoRepo;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota>listaMascotas = mascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascoRepo.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return mascoRepo.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Long idOriginal, Long id_mascotaNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        //busco el objeto original
        Mascota masco = this.findMascota(idOriginal);
        
        //proceso de modificación a nivel lógico
        masco.setId_mascota(id_mascotaNueva);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);
        
        //guardar los cambios
        this.saveMascota(masco);
    }
    
    //------------------ extra ----------------------------

    @Override
    public List<Mascota> getRaza() {
        List<Mascota>listaMascotas = mascoRepo.findAll();
        List<Mascota>listaCaniche = new ArrayList<>();        
        String especie,raza;
        
        for(Mascota masco:listaMascotas){   
            especie = masco.getEspecie();
            raza = masco.getRaza();
            
            if(especie.contains("perro") && raza.contains("caniche")){
                
                    listaCaniche.add(masco);
                    //System.out.println("Lista caniche:" + listaCaniche);
                }                
            }
        return listaCaniche;
    }   
    
}
