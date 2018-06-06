/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.EvaRespuestaPreguntaFacade;
import ec.edu.espe.arquitectura.educacion.model.EvaRespuestaPregunta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author js_cm
 */
@Stateless
@LocalBean
public class EvaRespuestaPreeguntaService {

    @EJB
    private EvaRespuestaPreguntaFacade evaRespuestaPreeguntaFacade;
    
    public List<EvaRespuestaPregunta> obtenerTodos() {
        return this.evaRespuestaPreeguntaFacade.findAll();
    }
    
    public void crear(EvaRespuestaPregunta evaRespuestaPregunta){
        this.evaRespuestaPreeguntaFacade.create(evaRespuestaPregunta);
    }
}
