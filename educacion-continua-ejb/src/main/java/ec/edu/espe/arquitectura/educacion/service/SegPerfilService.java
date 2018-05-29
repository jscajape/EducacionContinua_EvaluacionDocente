/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.SegPerfilFacade;
import ec.edu.espe.arquitectura.educacion.model.SegPerfil;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author js_cm
 */
@Stateless
@LocalBean
public class SegPerfilService {
    
    @EJB
    private SegPerfilFacade segPerfilFacade;
    
    public List<SegPerfil> obtenerTodos() {
        return this.segPerfilFacade.findAll();
    }

    public void crear(SegPerfil segPerfil) {
        this.segPerfilFacade.create(segPerfil);
    }
    
    public void modificar(SegPerfil segPerfil) {
        this.segPerfilFacade.edit(segPerfil);
    }
    
    public void eliminar(String codigo) {
        SegPerfil segPerfil = this.segPerfilFacade.find(codigo);
        this.segPerfilFacade.remove(segPerfil);
    } 
}
