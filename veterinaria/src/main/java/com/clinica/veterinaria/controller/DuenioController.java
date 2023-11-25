/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.dto.veterinariaDTO;
import com.clinica.veterinaria.model.Duenio;
import com.clinica.veterinaria.service.IDuenioService;
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
public class DuenioController {
    @Autowired
    private IDuenioService duenioServ;
    
    //CRUD endpoints
    
    @GetMapping("/duenios/traer")
    public List<Duenio> getDuenios(){
        return duenioServ.getDuenios();
    }
    
    @PostMapping("/duenios/crear")
    public String saveDuenio(@RequestBody Duenio duenio){
        duenioServ.saveDuenio(duenio);
        
        return "Duenio se creó correctamente";
    }
    
    @DeleteMapping("/duenios/borrar/{id}")
    public String deleteDuenio(@PathVariable Long id){
        duenioServ.deleteDuenio(id);
        
        return "Duenio se borró correctamente";
    }
    
    @PutMapping("/duenio/editar/{id_original}")
    public Duenio editDuenio(@PathVariable Long id_original,
            @RequestParam(required=false,name="id")Long idNueva,
            @RequestParam(required=false,name="nombre")String nuevoNombre,
            @RequestParam(required=false,name="dni") String nuevodni,
            @RequestParam(required=false,name="apellido")String nuevoApellido,
            @RequestParam(required=false,name="celular")Long nuevoCelular){
            
        duenioServ.editDuenio(id_original, idNueva, nuevodni, nuevoNombre, nuevoApellido, nuevoCelular);
        
        Duenio duenio = duenioServ.findDuenio(idNueva);
        
        return duenio;
    }
    
    @PutMapping("/duenios/editar")
    public Duenio editDuenio(@RequestBody Duenio duenio){
      duenioServ.editDuenio(duenio);
       
       return duenioServ.findDuenio(duenio.getId_duenio());
    }
    
    //extra DTO
    @GetMapping("/duenio/mascota/datos")
    public List<veterinariaDTO> listavetDTO(){        
        
        return duenioServ.listaDTO();
    }
    
}
