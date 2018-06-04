/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.dao;

import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsHorario;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author js_cm
 */
@Stateless
public class InsHorarioFacade extends AbstractFacade<InsHorario> {

    @PersistenceContext(unitName = "educacion_continua-evaluacion_docente")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsHorarioFacade() {
        super(InsHorario.class);
    }
    public List<InsHorario> buscarPorClase(InsClase clase)
    {
        List<InsHorario> horarios=super.findAll();
        return horarios.stream().filter(x -> x.getInsClase().getCodigo().getCodClase().equals(
               clase.getCodigo().getCodClase()
            )).collect(Collectors.toList());
    }
    
}
