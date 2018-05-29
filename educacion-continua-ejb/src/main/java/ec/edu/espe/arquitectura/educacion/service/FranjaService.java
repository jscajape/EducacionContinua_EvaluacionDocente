/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import ec.edu.espe.arquitectura.educacion.dao.InsFranjaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsFranja;
import java.util.List;
import javax.ejb.EJB;
/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class FranjaService {
    
    @EJB
    private InsFranjaFacade franjaFacade;
    public List<InsFranja> obtenerTodos() {
        return this.franjaFacade.findAll();
    }

    
            
}
