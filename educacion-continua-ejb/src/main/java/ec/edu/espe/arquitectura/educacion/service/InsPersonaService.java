/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsPersonaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
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
public class InsPersonaService {
    
    @EJB
    private InsPersonaFacade insPersonaFacade;
    
    public List<InsPersona> obtenerTodos() {
        return this.insPersonaFacade.findAll();
    }
  
       public InsPersona obtenerPorCodigo(String cod) {
        return this.insPersonaFacade.buscarPorCodigo(cod).get(0);
    }
    public void crear(InsPersona insPersona) {
        if(this.insPersonaFacade.find(insPersona.getCodigo()) == null){
            this.insPersonaFacade.create(insPersona);
        }else{
            this.insPersonaFacade.edit(insPersona);
        }
        
    }
    
    public void modificar(InsPersona insPersona) {
        this.insPersonaFacade.edit(insPersona);
    }
    
    public void eliminar(String codigo) {
        InsPersona insPersona = this.insPersonaFacade.find(codigo);
        this.insPersonaFacade.remove(insPersona);
    } 
    
}
