/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clinica.veterinaria.service;

import com.clinica.veterinaria.model.Mascota;
import java.util.List;

/**
 *
 * @author moss_
 */
public interface IMascotaService {
    //lectura
    public List<Mascota>getMascotas();
    
    //alta
    public void saveMascota(Mascota masco);
    
    //baja
    public void deleteMascota(Long id_mascota);
    
   //lectura de un solo objeto 
   public Mascota  findMascota(Long id_mascota);
   
   //modificación
   public void editMascota(Long idOriginal, Long id_mascotaNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor);

   //extra
   public List<Mascota> getRaza();
}
