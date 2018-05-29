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
    
    public List<InsClase> buscarPorDocente(String codDocente) {
        Query qry = this.em.createQuery("SELECT obj FROM InsClase obj WHERE obj.insPersona.codigo =?1");
        qry.setParameter(1, codDocente);
        return qry.getResultList();
    }
    
    public List<InsClase> buscarPorEstudiante(String codEstudiante) {
        List<InsMatricula> listaMatricula=new ArrayList<InsMatricula>();
        List<InsClase> listaClases=new ArrayList<InsClase>();
        
        Query qry = this.em.createQuery("SELECT obj FROM InsMatricula obj WHERE obj.insPersona.codigo =?1");
        qry.setParameter(1, codEstudiante);
        listaMatricula=qry.getResultList();
        
        for(int i=0;i<listaMatricula.size();i++)
        {
            listaClases.add(listaMatricula.get(i).getInsClase());
        }
        
        return listaClases;
    }
        
    
}
