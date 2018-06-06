/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;


import ec.edu.espe.arquitectura.educacion.dao.InsMatriculaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Cristhian
 */
@Stateless
@LocalBean
public class InsMatriculaService {
    
    @EJB    
    private InsMatriculaFacade insMatriculaFacade;
    
    
    public List<InsMatricula> obtenerPorAlumno(String codigo) {
        return this.insMatriculaFacade.PorAlumno(codigo);
    }
   

}
