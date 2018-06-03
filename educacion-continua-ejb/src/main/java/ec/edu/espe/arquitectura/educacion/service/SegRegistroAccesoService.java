/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.SegRegistroAccesoFacade;
import ec.edu.espe.arquitectura.educacion.model.SegRegistroAcceso;
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
public class SegRegistroAccesoService {
    
    @EJB
    private SegRegistroAccesoFacade registroAccesoFacade;
    
    public List<SegRegistroAcceso> obtenerTodos() {
        return this.registroAccesoFacade.findAll();
    }

    public void crear(SegRegistroAcceso segRegistroAcceso) {
        this.registroAccesoFacade.create(segRegistroAcceso);
    }
}
