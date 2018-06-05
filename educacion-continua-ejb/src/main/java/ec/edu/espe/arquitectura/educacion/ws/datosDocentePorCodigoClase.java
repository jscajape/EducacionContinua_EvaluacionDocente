/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.ws;

import ec.edu.espe.arquitectura.educacion.dao.InsClaseFacade;
import ec.edu.espe.arquitectura.educacion.dao.SegUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaWS;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
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
    @EJB     
    private SegUsuarioFacade segUsuarioFacade;
    
    public List<InsClase> obtenerTodos() {
        return this.claseFacade.findAll();
    }
    
    public InsPersonaWS datosDocente(String codClase)
    {
        List<InsClase> clasesTodas=this.obtenerTodos();
        InsClase objClase=new InsClase();
        InsPersonaWS personaWS = new InsPersonaWS();
        SegUsuario usuarioDocente = new SegUsuario();

        for(InsClase obj : clasesTodas)
        {
            if(obj.getCodigo().getCodClase().compareTo(codClase)==0)
            {
                objClase=obj;
                usuarioDocente = this.segUsuarioFacade.findByCodigo(objClase.getInsPersona().getCodigo()).get(0);
                personaWS.setCodigo(objClase.getInsPersona().getCodigo());
                personaWS.setNombre(objClase.getInsPersona().getNombre());
                personaWS.setApellido(objClase.getInsPersona().getApellido());
                personaWS.setDireccion(objClase.getInsPersona().getDireccion());
                personaWS.setFecNac(objClase.getInsPersona().getFecNac());
                personaWS.setGenero(objClase.getInsPersona().getGenero());
                personaWS.setTelefono(objClase.getInsPersona().getTelefono());
                personaWS.setCorreoElectronico(usuarioDocente.getCorreoElectronico());
                personaWS.setEstadoUsuario(usuarioDocente.getEstado().name());
                break;
            }
        }
        
        return personaWS;
        
    }
    
    
}
