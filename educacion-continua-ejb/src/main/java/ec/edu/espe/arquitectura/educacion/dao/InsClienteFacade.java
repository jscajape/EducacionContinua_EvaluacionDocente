/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsCliente;
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
public class InsClienteFacade extends AbstractFacade<InsCliente> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsClienteFacade() {
        super(InsCliente.class);
    }

    public List<InsCliente> PorCliente(String numdocumento) {
        Query qry = this.em.createQuery("SELECT obj FROM InsCliente obj WHERE obj.numDocumento =?1");
        qry.setParameter(1, numdocumento);
        return qry.getResultList();
    }
}
