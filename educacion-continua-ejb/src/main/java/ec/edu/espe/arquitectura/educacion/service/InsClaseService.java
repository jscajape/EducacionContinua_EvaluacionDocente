/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsClaseFacade;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés
 */
@Stateless
@LocalBean
public class InsClaseService {
    
    @EJB 
    
    private InsClaseFacade claseFacade;
    
    public List<InsClase> obtenerTodos() {
        return this.claseFacade.findAll();
    }
    
    public List<InsClase> obtenerPorDocente(String docente) {
        return this.claseFacade.PorDocente(docente);
    }
    
    public List<InsClase> obtenerPorEstudiante(String estudiante) {
        return this.claseFacade.PorEstudiante(estudiante);
    }
}
