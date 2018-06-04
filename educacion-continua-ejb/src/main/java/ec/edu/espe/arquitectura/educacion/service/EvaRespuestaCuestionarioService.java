/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.EvaRespuestaCuestionarioFacade;
import ec.edu.espe.arquitectura.educacion.dao.EvaRespuestaPreguntaFacade;
import ec.edu.espe.arquitectura.educacion.dao.EvaResultadoEvaluacionFacade;
import ec.edu.espe.arquitectura.educacion.model.EvaEvaluacion;
import ec.edu.espe.arquitectura.educacion.model.EvaRespuestaCuestionario;
import ec.edu.espe.arquitectura.educacion.model.EvaRespuestaPregunta;
import ec.edu.espe.arquitectura.educacion.model.EvaResultadoEvaluacion;
import ec.edu.espe.arquitectura.educacion.model.EvaResultadoEvaluacionPK;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Andrés
 */
@Stateless
@LocalBean
public class EvaRespuestaCuestionarioService {

    @EJB
    private EvaResultadoEvaluacionFacade evaResEvaFacade;
    
    public void guardarRespuesta(List<EvaRespuestaPregunta> respPregs)
    {
        System.out.println("Si hace la invocacion!!!");
        //List<EvaRespuestaPregunta> evaRespuestasAlm=this.evaRespPregFacade.findAll();
        EvaRespuestaPregunta evaRespPregAux=respPregs.get(0);
        
        float sum=0.0f;
        //int i=0;
        for(EvaRespuestaPregunta obj : respPregs)
        {
            //i++;
            System.out.println(obj.getRespuesta());
            sum+=(float)obj.getRespuesta();
            
            //evaRespPregAux.setCodigo(evaRespPregAux.getCodigo()+i);
            //evaRespPregAux.setEvaPregunta(obj.getEvaPregunta());
            //evaRespPregAux.setInsPersona(obj.getInsPersona());
            //evaRespPregAux.setRespuesta(obj.getRespuesta());
            
            //this.evaRespPregFacade.create(evaRespPregAux);
            
            //this.evaRespPregFacade.create(obj);
            //this.evaRespPregFacade.create(new EvaRespuestaPregunta());
            //evaRespPregFacade.create(new EvaRespuestaPregunta(obj.getCodigo(),obj.getRespuesta(),obj.getInsPersona().getCodigo(),obj.getEvaPregunta().getCodigo()));
        }
        sum=(sum/(float)respPregs.size());
        //System.out.println("Antes de BigDecimal: "+sum);
        BigDecimal bd=BigDecimal.valueOf((double)sum);
        
        System.out.println("Promedio Evaluacion: "+bd);
        
//        EvaResultadoEvaluacion evaResEva=new EvaResultadoEvaluacion();
//        
//        evaResEva.setCodigo(new EvaResultadoEvaluacionPK(eva.getCodigo(),clase.getCodigo().getCodClase()));
//        evaResEva.setEvaEvaluacion(eva);
//        evaResEva.setInsClase(clase);
//        evaResEva.setPromedioTotal(bd);
        
        //this.evaResEvaFacade.create(evaResEva);
        
        //evaRespCuest.setCalificacionPromedio(bd);
        
        //evaRespuestaCuestionarioFacade.create(evaRespCuest);
        
    }
    
}
