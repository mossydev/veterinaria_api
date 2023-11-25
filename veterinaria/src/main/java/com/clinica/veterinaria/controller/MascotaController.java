/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author moss_
 */
@RestController
public class MascotaController {
    @Autowired
    private IMascotaService mascoServ;
    
    @GetMapping("/mascotas/traer")
    private List<Mascota> listaMascotas(){
        return mascoServ.getMascotas();
    }
    
    @PostMapping("/mascotas/crear")
    private String saveMascota(@RequestBody Mascota mascota){
        mascoServ.saveMascota(mascota);
        
        return "La mascota se creó correctamente";
    }
    
    @DeleteMapping("/mascotas/borrar/{id}")
    private String deleteMascota(@PathVariable Long id){
        mascoServ.deleteMascota(id);
        
        return "La mascota fue eliminada correctamente";
    }
    
    @PutMapping("/mascotas/editar/{id_original}")
    public Mascota editMascota(@PathVariable Long id_original,
            @RequestParam(required=false,name="id")Long idNueva,
            @RequestParam(required=false,name="nombre")String nuevoNombre,
            @RequestParam(required=false,name="especie")String nuevaEspecie,
            @RequestParam(required=false,name="raza")String nuevaRaza,
            @RequestParam(required=false, name="color")String nuevoColor){
        
        mascoServ.editMascota(id_original, idNueva, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor);
    
        Mascota masco= mascoServ.findMascota(idNueva);
        
        return masco;
    }
    
    //---------------------- endpoints extra ----------------------------------
     @GetMapping("/mascotas/traerPerrosCaniche")
        private List<Mascota> listaCaniche(){
        
        return mascoServ.getRaza();
    }
}
