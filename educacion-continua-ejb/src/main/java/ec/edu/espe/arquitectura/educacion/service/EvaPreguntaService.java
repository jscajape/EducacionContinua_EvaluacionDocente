/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.EvaPreguntaFacade;
import ec.edu.espe.arquitectura.educacion.dao.InsPersonaUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.dao.SegRolFacade;
import ec.edu.espe.arquitectura.educacion.model.EvaPregunta;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.model.SegRol;
import java.util.ArrayList;
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
public class EvaPreguntaService {
    
    @EJB
    private EvaPreguntaFacade evaPreguntaFacade;
       
    public List<EvaPregunta> cargarCuestionario(String codRol, String codEvaluacion)
    {
        return this.evaPreguntaFacade.cargarCuestionario(codRol, codEvaluacion);
    }
    
    public List<EvaPregunta> todas()
    {
        return this.evaPreguntaFacade.findAll();
    }
    
    
    
}
