/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.ws;

import ec.edu.espe.arquitectura.educacion.dao.InsMatriculaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
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

    public List<InsMatricula> obtenerTodos() {
        return this.insMatFacade.findAll();
    }

    public List<InsPersona> matriculaPorCodifo(String codClase) {
        List<InsMatricula> matriculasTodas = this.obtenerTodos();
        List<InsPersona> listadoAlumnos = new ArrayList<>();

        for (InsMatricula obj : matriculasTodas) 
        {
            if (obj.getInsClase().getCodigo().getCodClase().compareTo(codClase) == 0)
            {
                listadoAlumnos.add(obj.getInsPersona());
            }
        }

        return listadoAlumnos;

    }

}
