/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author js_cm
 */
@Stateless
public class InsMatriculaFacade extends AbstractFacade<InsMatricula> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsMatriculaFacade() {
        super(InsMatricula.class);
    }
      public List<InsMatricula> PorAlumno(String codigo) {
        Query qry = this.em.createQuery("SELECT obj FROM InsMatricula obj WHERE obj.insPersona.codigo =?1");
        qry.setParameter(1, codigo);       
        return qry.getResultList();
    }
    public List<InsMatricula> PorAlumno(String codigo,String estado) {
        Query qry = this.em.createQuery("SELECT obj FROM InsMatricula obj WHERE obj.insPersona.codigo =?1 AND obj.estado=?2");
        qry.setParameter(1, codigo);
        qry.setParameter(2, estado);
        
        return qry.getResultList();
    }
    
 
    
  
    
}
