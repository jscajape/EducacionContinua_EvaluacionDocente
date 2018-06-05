/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import java.util.ArrayList;
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
    
      public List<InsMatricula> buscarPorAlumno(String cosAlumno) {
        List<InsMatricula> listaClases = new ArrayList<InsMatricula>();

        Query qry = this.em.createQuery("SELECT obj FROM InsMatricula obj WHERE obj.insPersona.codigo =?1");
        qry.setParameter(1, cosAlumno);
        listaClases = qry.getResultList();
        return listaClases;
        
    }

}
