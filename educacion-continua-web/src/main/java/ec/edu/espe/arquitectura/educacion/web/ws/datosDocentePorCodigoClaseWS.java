/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web.ws;

import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import ec.edu.espe.arquitectura.educacion.ws.datosDocentePorCodigoClase;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Andrés
 */
@WebService(serviceName = "datosDocentePorCodigoClaseWS")
public class datosDocentePorCodigoClaseWS {

    @EJB
    private datosDocentePorCodigoClase ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "obtenerTodos")
    public List<InsClase> obtenerTodos() {
        return ejbRef.obtenerTodos();
    }

    @WebMethod(operationName = "datosDocente")
    public InsPersona datosDocente(@WebParam(name = "codClase") String codClase) {
        return ejbRef.datosDocente(codClase);
    }
    
}
