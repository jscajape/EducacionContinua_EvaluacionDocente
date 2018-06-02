/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.SegPerfil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author js_cm
 */
@Stateless
public class SegPerfilFacade extends AbstractFacade<SegPerfil> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegPerfilFacade() {
        super(SegPerfil.class);
    }
    
    public SegPerfil findByID(String identificacion){
        Query qry = this.em.createQuery("SELECT obj FROM SegPerfil obj WHERE obj.codigo=?1");
        qry.setParameter(1, identificacion);
        return  (SegPerfil) qry.getSingleResult();  
    } 
    
}
