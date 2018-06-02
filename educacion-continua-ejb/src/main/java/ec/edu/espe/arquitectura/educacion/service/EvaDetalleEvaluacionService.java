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
import ec.edu.espe.arquitectura.educacion.model.EvaDetalleEvaluaconPK;
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
public class EvaDetalleEvaluacionService {
    
    @EJB
    private EvaDetalleEvaluaconFacade evaDetEva;
    
    public EvaDetalleEvaluacon porId(String id1, String id2)
    {
        List<EvaDetalleEvaluacon> edeList= evaDetEva.findAll();
        
        EvaDetalleEvaluacon resp=new EvaDetalleEvaluacon();
        
        for(EvaDetalleEvaluacon obj : edeList)
        {
            if((obj.getCodigo().getCodCuestionario().compareTo(id1)==0)&&(obj.getCodigo().getCodEvaluacion().compareTo(id2)==0))
            {
                resp=obj;
                break;
            }
        }
        return resp;
    }
       
        
    
}
