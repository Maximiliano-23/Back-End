/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.Maximiliano_Pereira.Interface;

import com.portfolio.Maximiliano_Pereira.Entity.Persona;
import java.util.List;

/**
 *
 * @author GUSTAVO
 */
public interface IPersonaService {
    //Traer una lista persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto, pero lo buscamos por ID;
    public void DeletePersona(Long id);
    
    //Buscar persona
    public Persona findPersona(Long id);
}
