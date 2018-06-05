/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.EvaDetalleEvaluaconFacade;
import ec.edu.espe.arquitectura.educacion.dao.EvaEvaluacionFacade;
import ec.edu.espe.arquitectura.educacion.dao.EvaPreguntaFacade;
import ec.edu.espe.arquitectura.educacion.dao.InsPersonaUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.dao.SegRolFacade;
import ec.edu.espe.arquitectura.educacion.model.EvaDetalleEvaluacon;
import ec.edu.espe.arquitectura.educacion.model.EvaEvaluacion;
import ec.edu.espe.arquitectura.educacion.model.EvaPregunta;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.model.SegRol;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés
 */
@Stateless
@LocalBean
public class EvaEvaluacionService {
    
    @EJB
    private EvaEvaluacionFacade evaEvaluacionFacade;
    
    public EvaEvaluacion porId(String id)
    {
        List<EvaEvaluacion> edeList= evaEvaluacionFacade.findAll();
        EvaEvaluacion resp=new EvaEvaluacion();
        
        for(EvaEvaluacion obj : edeList)
        {
            if(obj.getCodigo().compareTo(id)==0)
            {
                resp=obj;
                break;
            }
        }
        return resp;
    }
       
        
    
}
