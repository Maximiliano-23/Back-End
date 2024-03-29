/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Maximiliano_Pereira.Controller;


import com.portfolio.Maximiliano_Pereira.Entity.Persona;
import com.portfolio.Maximiliano_Pereira.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author GUSTAVO
 */
@RestController
@CrossOrigin(origins = "https://frontend-maximilianopereira.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
     @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.DeletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //URL:puerto/personas/editar/4/nombre & apellido & img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/{id}")
        public Persona editPersona(@PathVariable Long id,
                                   @RequestParam("nombre") String nuevoNombre,
                                   @RequestParam("apellido") String nuevoApellido,
                                   @RequestParam("img") String nuevoImg){
            Persona persona = ipersonaService.findPersona(id);
            persona.setNombre(nuevoNombre);
            persona.setApellido(nuevoApellido);
            persona.setImg(nuevoImg);
            
            ipersonaService.savePersona(persona);
            return persona;
        }
     @GetMapping("/personas/traer/perfil")
     public Persona findPersona(){
         return ipersonaService.findPersona((long)2);
     }
    
}
