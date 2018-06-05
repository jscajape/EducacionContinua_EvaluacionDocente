/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web.ws;

import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaWS;
import ec.edu.espe.arquitectura.educacion.ws.listaEstudiantesPorCodigoClase;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Andrés
 */
@WebService(serviceName = "listaEstudiantesPorCodigoClaseWS")
public class listaEstudiantesPorCodigoClaseWS {

    @EJB
    private listaEstudiantesPorCodigoClase ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "obtenerTodos")
    public List<InsMatricula> obtenerTodos() {
        return ejbRef.obtenerTodos();
    }

    @WebMethod(operationName = "matriculaPorCodifo")
    public List<InsPersonaWS> matriculaPorCodifo(@WebParam(name = "codClase") String codClase) {
        return ejbRef.matriculaPorCodifo(codClase);
    }
    
}
