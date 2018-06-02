/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.SegUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@LocalBean
@Stateless
public class AutenticacionService {
    
    @EJB
    private SegUsuarioFacade segUsuarioFacade;
    
    public SegUsuario login(String codUsuario, String clave) {
        SegUsuario usuario = this.segUsuarioFacade.find(codUsuario);
        if (usuario!=null && usuario.getClave().equals(clave)) {
            return usuario;
        } else {
            return null;
        }
    }
}
