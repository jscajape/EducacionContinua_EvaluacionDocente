/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
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
public class SegUsuarioFacade extends AbstractFacade<SegUsuario> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUsuarioFacade() {
        super(SegUsuario.class);
    }
    
    public List<SegUsuario> findByCodigo(String codigo) {
        Query qry = this.em.createQuery("SELECT obj FROM SegUsuario obj WHERE obj.codigo=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();
    }
}
