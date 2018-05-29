/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.services;

import ec.edu.espe.arquitectura.educacion.dao.InsAreaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsArea;
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
public class InsAreaServ {

    @EJB
    private InsAreaFacade areaFacade;
    
    public List<InsArea> obtenerTodos() {
        return this.areaFacade.findAll();
    }
    
    public void crear(InsArea area) {
        this.areaFacade.create(area);
    }
    
    public void modificar(InsArea area) {
        this.areaFacade.edit(area);
    }
    
    public void eliminar(int codigo) {
        InsArea area = this.areaFacade.find(codigo);
        this.areaFacade.remove(area);
    }
}