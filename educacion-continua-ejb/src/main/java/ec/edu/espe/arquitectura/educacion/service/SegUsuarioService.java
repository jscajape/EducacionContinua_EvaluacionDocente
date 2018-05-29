/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.SegUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
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
public class SegUsuarioService {
    
    @EJB
    private SegUsuarioFacade segUsuarioFacade;
    
    public List<SegUsuario> obtenerTodos() {
        return this.segUsuarioFacade.findAll();
    }
    
    public SegUsuario obtenerPorCodigo(String codigo){
        return this.segUsuarioFacade.findByCodigo(codigo).get(0);
    }

    public void crear(SegUsuario segUsuario) {
        if(this.segUsuarioFacade.find(segUsuario.getCodigo()) == null){
            this.segUsuarioFacade.create(segUsuario);
        }else{
            this.segUsuarioFacade.create(segUsuario);
        }
    }
    
    public void modificar(SegUsuario segUsuario) {
        this.segUsuarioFacade.edit(segUsuario);
    }
    
    public void eliminar(String codigo) {
        SegUsuario segUsuario = this.segUsuarioFacade.find(codigo);
        this.segUsuarioFacade.remove(segUsuario);
    }
    
}
