/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsPersonaUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.dao.SegRolFacade;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.model.SegRol;
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
public class InsPersonaUsuarioService {
    
    @EJB
    private InsPersonaUsuarioFacade perUsFacade;
    
    public List<InsPersonaUsuario> obtenerTodos() {
        return this.perUsFacade.findAll();
    }
    public List<InsPersonaUsuario> obtenerPorUsuario(String codUsuario) {
        return this.perUsFacade.PorUsuario(codUsuario);
    }
    public List<InsPersonaUsuario> obtenerPorRol(String codRol) {
        return this.perUsFacade.PorRol(codRol);
    }
    
}
