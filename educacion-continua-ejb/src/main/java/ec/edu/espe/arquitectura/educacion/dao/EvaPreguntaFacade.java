/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.EvaDetalleEvaluacon;
import ec.edu.espe.arquitectura.educacion.model.EvaPregunta;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
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
public class EvaPreguntaFacade extends AbstractFacade<EvaPregunta> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaPreguntaFacade() {
        super(EvaPregunta.class);
    }
    
    public List<EvaPregunta> cargarCuestionario(String codRol, String codEvaluacion) {
        
        List<EvaPregunta> preguntasResp=new ArrayList<EvaPregunta>();
        List<EvaDetalleEvaluacon> listaEvaluacones=new ArrayList<EvaDetalleEvaluacon>();
        
        Query qry = this.em.createQuery("SELECT obj FROM EvaDetalleEvaluacon obj WHERE obj.segRol.codigo=?1 AND obj.evaEvaluacion.codigo=?2");
        qry.setParameter(1, codRol);
        qry.setParameter(2, codEvaluacion);
        listaEvaluacones=qry.getResultList();
        
        for(int i=0;i<listaEvaluacones.size();i++)
        {
            System.out.println(listaEvaluacones.get(i).getSegRol().getNombre());
        }
        
        Query qry1 = this.em.createQuery("SELECT obj FROM EvaPregunta obj WHERE obj.evaCuestionario.codigo =?1");
        qry1.setParameter(1, listaEvaluacones.get(0).getEvaCuestionario().getCodigo());
        preguntasResp=qry1.getResultList();
        
        for(int i=0;i<preguntasResp.size();i++)
        {
            System.out.println(preguntasResp.get(i).getEnunciado());
        }
        
        return preguntasResp;
    }
    
}
