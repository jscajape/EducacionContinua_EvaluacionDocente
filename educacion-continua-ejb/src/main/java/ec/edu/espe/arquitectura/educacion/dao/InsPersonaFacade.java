/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author js_cm
 */
@Stateless
@LocalBean
public class InsPersonaFacade extends AbstractFacade<InsPersona> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsPersonaFacade() {
        super(InsPersona.class);
    }

       public List<InsPersona> buscarPorCodigo(String codProf) {
        Query qry = this.em.createQuery("SELECT obj FROM InsPersona obj WHERE obj.codigo=?1");
        qry.setParameter(1, codProf);
        return qry.getResultList();
    }
    
}
