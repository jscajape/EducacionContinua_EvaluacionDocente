/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
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
public class InsPersonaUsuarioFacade extends AbstractFacade<InsPersonaUsuario> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsPersonaUsuarioFacade() {
        super(InsPersonaUsuario.class);
    }
    
    public List<InsPersonaUsuario> PorUsuario(String codUsuario) {
    Query qry = this.em.createQuery("SELECT obj FROM InsPersonaUsuario obj WHERE obj.codigo.codPersona =?1)");
    qry.setParameter(1, codUsuario);
    return qry.getResultList();
    }
    
}
