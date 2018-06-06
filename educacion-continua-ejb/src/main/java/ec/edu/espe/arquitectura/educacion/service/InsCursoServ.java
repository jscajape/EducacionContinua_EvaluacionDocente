/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsClaseFacade;
import ec.edu.espe.arquitectura.educacion.dao.InsCursoFacade;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsCurso;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author ALCI
 */
@Stateless
@LocalBean
public class InsCursoServ {
    @EJB
    private InsCursoFacade cursofacade;
    
    public List<InsCurso> obtenerTodos(){
        return this.cursofacade.findAll();
    }
    public List<InsCurso> buscarporArea(Integer codArea){
        return this.cursofacade.buscarPorArea(codArea);
    }
    public void crear(InsCurso curso)
    {
       this.cursofacade.create(curso);
    }
    public void modificar(InsCurso curso){
        this.cursofacade.edit(curso);
    }
    public void eliminar(InsCurso curso){
        this.cursofacade.remove(curso);
    }
 
}
