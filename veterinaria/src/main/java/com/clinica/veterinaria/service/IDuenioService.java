/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clinica.veterinaria.service;

import com.clinica.veterinaria.dto.veterinariaDTO;
import com.clinica.veterinaria.model.Duenio;
import com.clinica.veterinaria.model.Mascota;
import java.util.List;

/**
 *
 * @author moss_
 */
public interface IDuenioService {
    //lectura
    public List<Duenio>getDuenios();
    
    //alta
    public void saveDuenio(Duenio duenio);
    
    //baja
    public void deleteDuenio(Long id_duenio);
    
   //lectura de un solo objeto 
   public Duenio  findDuenio(Long id_duenio);
   
   //modificación
   public void editDuenio(Long idOriginal, Long id_duenioNuevo,String nuevodni, String nuevoNombre, String nuevoApellido, Long nuevoCelular);

   public void editDuenio(Duenio duenio);
   
   //extra DTO
   public List<veterinariaDTO> listaDTO();   
  
}
