/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.ws;

import ec.edu.espe.arquitectura.educacion.dao.InsMatriculaFacade;
import ec.edu.espe.arquitectura.educacion.dao.SegUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaWS;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import java.util.ArrayList;
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
public class listaEstudiantesPorCodigoClase {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private InsMatriculaFacade insMatFacade;
    @EJB     
    private SegUsuarioFacade segUsuarioFacade;

    public List<InsMatricula> obtenerTodos() {
        return this.insMatFacade.findAll();
    }

    public List<InsPersonaWS> matriculaPorCodifo(String codClase) {
        List<InsMatricula> matriculasTodas = this.obtenerTodos();
        List<InsPersonaWS> listadoAlumnos = new ArrayList<>();
        
        

        for (InsMatricula obj : matriculasTodas) 
        {
            InsPersonaWS personaWS = new InsPersonaWS();
            if (obj.getInsClase().getCodigo().getCodClase().compareTo(codClase) == 0)
            {
                SegUsuario usuarioDocente = new SegUsuario();
                usuarioDocente = this.segUsuarioFacade.findByCodigo(obj.getInsPersona().getCodigo()).get(0);
                personaWS.setCodigo(obj.getInsPersona().getCodigo());
                personaWS.setNombre(obj.getInsPersona().getNombre());
                personaWS.setApellido(obj.getInsPersona().getApellido());
                personaWS.setDireccion(obj.getInsPersona().getDireccion());
                personaWS.setFecNac(obj.getInsPersona().getFecNac());
                personaWS.setGenero(obj.getInsPersona().getGenero());
                personaWS.setTelefono(obj.getInsPersona().getTelefono());
                personaWS.setCorreoElectronico(usuarioDocente.getCorreoElectronico());
                personaWS.setEstadoUsuario(usuarioDocente.getEstado().name());
                listadoAlumnos.add(personaWS);
            }
        }

        return listadoAlumnos;

    }

}
