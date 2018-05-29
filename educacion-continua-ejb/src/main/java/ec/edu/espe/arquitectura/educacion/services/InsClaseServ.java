/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.services;

import ec.edu.espe.arquitectura.educacion.dao.InsClaseFacade;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
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
public class InsClaseServ {
    @EJB
    private InsClaseFacade clasefacade;
    
    public List<InsClase> obtenerTodos(){
        return this.clasefacade.findAll();
    }
    public void crear(InsClase clase)
    {
       this.clasefacade.create(clase);
    }
    public void modificar(InsClase clase){
        this.clasefacade.edit(clase);
    }
    public void eliminar(InsClase clase){
        this.clasefacade.remove(clase);
    }
}
