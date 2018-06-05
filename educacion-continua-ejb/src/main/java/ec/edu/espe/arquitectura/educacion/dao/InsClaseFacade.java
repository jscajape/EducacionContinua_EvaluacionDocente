/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
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
       public List<InsPersona> buscarPorProfesor(String codProf) {
        Query qry = this.em.createQuery("SELECT obj FROM InsPersona obj WHERE obj.tipo=?1");
        qry.setParameter(1, codProf);
        return qry.getResultList();
    }
   
    public List<InsClase> buscarPorDocente(String codDocente) {
        Query qry = this.em.createQuery("SELECT obj FROM InsClase obj WHERE obj.insPersona.codigo =?1");
        qry.setParameter(1, codDocente);
        return qry.getResultList();
    }
    public List<InsClase> buscarMaximo() {
        Query qry = this.em.createQuery("SELECT obj FROM InsClase obj where obj.codigo  =  (SELECT max(obj.codigo) FROM InsClase)");
        
        return qry.getResultList();
    }
    /* public String buscarMax() {
        Query qry = this.em.createQuery("SELECT obj FROM InsClase obj where obj.codigo  =  (SELECT max(obj.codigo) FROM InsClase)");
        
        return (String)qry;
    }*/
    public List<InsClase> buscarPorEstudiante(String codEstudiante) {
        List<InsMatricula> listaMatricula = new ArrayList<InsMatricula>();
        List<InsClase> listaClases = new ArrayList<InsClase>();

        Query qry = this.em.createQuery("SELECT obj FROM InsMatricula obj WHERE obj.insPersona.codigo =?1");
        qry.setParameter(1, codEstudiante);
        listaMatricula = qry.getResultList();

        for (int i = 0; i < listaMatricula.size(); i++) {
            listaClases.add(listaMatricula.get(i).getInsClase());
        }

        return listaClases;
    }

    public List<InsClase> buscarPorArea(Integer codArea) {
        List<InsClase> listaClases = new ArrayList<InsClase>();

        Query qry = this.em.createQuery("SELECT obj FROM InsClase obj WHERE obj.insCurso.codigo =?1");
        qry.setParameter(1, codArea);
        listaClases = qry.getResultList();
        return listaClases;
        
    }

}
