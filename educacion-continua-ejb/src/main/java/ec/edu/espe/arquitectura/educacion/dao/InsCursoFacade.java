/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsArea;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsCurso;
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
public class InsCursoFacade extends AbstractFacade<InsCurso> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsCursoFacade() {
        super(InsCurso.class);
    }
    
       public List<InsCurso> buscarPorArea(Integer codArea) {
        Query qry = this.em.createQuery("SELECT obj FROM InsCurso obj WHERE obj.insArea.codigo=?1");
        qry.setParameter(1, codArea);
        return qry.getResultList();
    }
       
}
