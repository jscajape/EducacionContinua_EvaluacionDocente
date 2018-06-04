/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.ws;

import ec.edu.espe.arquitectura.educacion.dao.InsClaseFacade;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
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
public class datosDocentePorCodigoClase {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB     
    private InsClaseFacade claseFacade;
    
    public List<InsClase> obtenerTodos() {
        return this.claseFacade.findAll();
    }
    
    public InsPersona datosDocente(String codClase)
    {
        List<InsClase> clasesTodas=this.obtenerTodos();
        InsClase objClase=new InsClase();
        
        for(InsClase obj : clasesTodas)
        {
            if(obj.getCodigo().getCodClase().compareTo(codClase)==0)
            {
                objClase=obj;
                break;
            }
        }
        
        return objClase.getInsPersona();
        
    }
    
    
}
