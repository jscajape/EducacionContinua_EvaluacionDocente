/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsClase;
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
public class InsClaseFacade extends AbstractFacade<InsClase> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsClaseFacade() {
        super(InsClase.class);
    }
    
    public List<InsClase> PorDocente(String codUsuario) {        
        //SELECT * FROM ins_clase WHERE COD_DOCENTE='7777777777' 
        // SELECT obj FROM InsClase obj WHERE obj.insPersona.codigo=?1
        Query qry = this.em.createQuery("SELECT obj FROM InsClase obj WHERE obj.insPersona.codigo=?1");
        qry.setParameter(1, codUsuario);
        return qry.getResultList();
    }
    
    public List<InsClase> PorEstudiante(String codUsuario) {        
        //SELECT * FROM ins_clase WHERE COD_CLASE IN (SELECT COD_CLASE FROM ins_matricula WHERE COD_ALUMNO='1724472186')
        Query qry = this.em.createQuery("SELECT obj FROM InsClase obj WHERE obj.codigo IN (SELECT obj1.insClase.codigo FROM InsMatricula obj1 WHERE obj1.insPersona.codigo=?1)");
        qry.setParameter(1, codUsuario);
        return qry.getResultList();
    }
    
}
