/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.EvaDetalleEvaluacon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author js_cm
 */
@Stateless
public class EvaDetalleEvaluaconFacade extends AbstractFacade<EvaDetalleEvaluacon> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaDetalleEvaluaconFacade() {
        super(EvaDetalleEvaluacon.class);
    }
    
    
}
